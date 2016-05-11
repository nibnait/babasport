package com.nibnait.babasport.core.controller;

import com.nibnait.babasport.common.web.ResponseUtils;
import com.nibnait.babasport.common.web.session.SessionProvider;
import com.nibnait.babasport.core.bean.BuyCart;
import com.nibnait.babasport.core.bean.BuyItem;
import com.nibnait.babasport.core.bean.product.Sku;
import com.nibnait.babasport.core.bean.user.Addr;
import com.nibnait.babasport.core.bean.user.Buyer;
import com.nibnait.babasport.core.query.user.AddrQuery;
import com.nibnait.babasport.core.service.product.SkuService;
import com.nibnait.babasport.core.service.user.AddrService;
import com.nibnait.babasport.core.web.Constants;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;


/**
 * 购物车
 * Created by nibnait on 2016/5/9.
 */

@Controller
public class CartController {

    @Autowired
    private SkuService skuService;
    @Autowired
    private SessionProvider sessionProvider;
    @Autowired
    private AddrService addrService;

    //购买按钮
    @RequestMapping(value = "/shopping/buyCart.shtml")
    public String buyCart(Integer skuId, Integer amount, Integer buyLimit, Integer productId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

        BuyCart buyCart = null;

        //判断Cookie中有没有购物车
        Cookie[] cookies = request.getCookies();
        buyCart = readBuyCartFromCookie(buyCart,cookies);

        //如果Cookie中还没有，则new一个BuyCart
        if (buyCart == null) {
            buyCart = new BuyCart();

        }

        if (skuId != null) {
            //往购物车中添加商品
            Sku sku = new Sku();
            sku.setId(skuId);
            if (buyLimit != null) {
                sku.setSkuUpperLimit(buyLimit);
            }
            BuyItem buyItem = new BuyItem();

            buyItem.setAmount(amount);
            buyItem.setSku(sku);
            if (amount == -1) {
                buyCart.subItem(buyItem);
            } else {
                buyCart.addItem(buyItem);
            }
            if (productId != null) {
                buyCart.setProductId(productId);
            }

            String buyCartJson = writeBuyCart2Json(buyCart);
            Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, buyCartJson);
            cookie.setMaxAge(60*60*24);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        //将购物车装满
        buyCart = loadCart(buyCart);
        model.addAttribute("buyCart", buyCart);

        return "product/cart";
    }

    //清空购物车
    @RequestMapping(value = "/shopping/clearCart.shtml")
    public String clearCart(HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "redirect:/shopping/buyCart.shtml";
    }

    //删除一个购物项
    @RequestMapping(value = "/shopping/deleteItem.shtml")
    public String deleteItem(HttpServletRequest request, Integer skuId, HttpServletResponse response) {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        BuyCart buyCart = null;

        //得到购物车Cookie
        Cookie[] cookies = request.getCookies();
        buyCart = readBuyCartFromCookie(buyCart,cookies);

        //删除skuId对应的BuyItem
        if (buyCart != null) {
            if (skuId != null) {
                //往购物车中添加商品
                Sku sku = new Sku();
                sku.setId(skuId);
                BuyItem buyItem = new BuyItem();
                buyItem.setSku(sku);

                buyCart.deleteItem(buyItem);//* deleteItem

                String buyCartJson = writeBuyCart2Json(buyCart);
                Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, buyCartJson);
                cookie.setMaxAge(60*60*24);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }


        return "redirect:/shopping/buyCart.shtml";
    }

    //结算按钮
    @RequestMapping(value = "/buyer/trueBuy.shtml")
    public String trueBuy(HttpServletRequest request,HttpServletResponse response,ModelMap model){

        //1:判断是否登陆
        Buyer buyer = (Buyer) sessionProvider.getAttribute(request,Constants.BUYER_SESSION,response);
        if (buyer != null){
            //2:判断购物车中是否有商品
            Cookie[] cookies = request.getCookies();
            BuyCart buyCart = null;
            buyCart = readBuyCartFromCookie(buyCart, cookies);
            if (buyCart !=null){
                //3:判断购物车中的各个购物项是否还有库存
                List<BuyItem> items = buyCart.getItems();
                int length = items.size();
                if (items!=null && length>0){
                    for (BuyItem item:items){
                        Sku sku = skuService.getSkuByKey(item.getSku().getId());
                        //如果库存小于购买数量
                        if (sku.getStockInventory()<=item.getAmount()){
                            buyCart.deleteItem(item);
                        }
                    }
                    //4:再判断购物车是否为空
                    if (items.size()<length){
                        //修改Cookie中的buyCart数据，重新跳转到购物车页面
                        String buyCartJson = writeBuyCart2Json(buyCart);
                        Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, buyCartJson);
                        cookie.setMaxAge(60*60*24);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        return "redirect:/shopping/buyCart.shtml";
                    }else {
                        //正常的情况：
                        // 加载收货地址
                        AddrQuery addrQuery = new AddrQuery();
                        addrQuery.setBuyerId(buyer.getUsername());
                        addrQuery.setIsDef(1);
                        List<Addr> addrList = addrService.getAddrList(addrQuery);
                        model.addAttribute("addr",addrList.get(0));

                        //将购物车装满
                        buyCart = loadCart(buyCart);
                        model.addAttribute("buyCart", buyCart);

                        return "product/productOrder";
                    }
                }else {
                    return "redirect:/shopping/buyCart.shtml";
                }
            }else {
                return "redirect:/shopping/buyCart.shtml";
            }
        }else {
            return "/shopping/login.shtml";
        }
    }


    private BuyCart loadCart(BuyCart buyCart) {
        List<BuyItem> items = buyCart.getItems();
        if (items != null) {
            for (BuyItem item : items) {
                item.setSku(skuService.getSkuByKey(item.getSku().getId()));
            }
        }
        return buyCart;
    }

    private String writeBuyCart2Json(BuyCart buyCart) {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        StringWriter str = new StringWriter();
        try {
            om.writeValue(str, buyCart);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    private BuyCart readBuyCartFromCookie(BuyCart buyCart, Cookie[] cookies) {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constants.BUYCART_COOKIE)) {
                    try {
                        return om.readValue(cookie.getValue(), BuyCart.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return null;
    }


}
