package com.nibnait.babasport.core.controller;

import com.nibnait.babasport.common.web.ResponseUtils;
import com.nibnait.babasport.core.bean.BuyCart;
import com.nibnait.babasport.core.bean.BuyItem;
import com.nibnait.babasport.core.bean.product.Sku;
import com.nibnait.babasport.core.service.product.SkuService;
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


    @RequestMapping(value = "/shopping/buyCart.shtml")
    public String buyCart(Integer skuId, Integer amount, Integer buyLimit, Integer productId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {

        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        BuyCart buyCart = null;

        //判断Cookie中有没有购物车
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constants.BUYCART_COOKIE)) {
                    try {
                        buyCart = om.readValue(cookie.getValue(), BuyCart.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                }
            }
        }

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

            StringWriter str = new StringWriter();
            try {
                om.writeValue(str, buyCart);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        //将购物车装满
        List<BuyItem> items = buyCart.getItems();
        if (items != null) {
            for (BuyItem item : items) {
                item.setSku(skuService.getSkuByKey(item.getSku().getId()));
            }
        }
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
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constants.BUYCART_COOKIE)) {
                    try {
                        buyCart = om.readValue(cookie.getValue(), BuyCart.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                }
            }
        }

        //删除skuId对应的BuyItem
        if (buyCart != null) {
            if (skuId != null) {
                //往购物车中添加商品
                Sku sku = new Sku();
                sku.setId(skuId);
                BuyItem buyItem = new BuyItem();
                buyItem.setSku(sku);

                buyCart.deleteItem(buyItem);//* deleteItem

                StringWriter str = new StringWriter();
                try {
                    om.writeValue(str, buyCart);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Cookie cookie = new Cookie(Constants.BUYCART_COOKIE, str.toString());
                cookie.setMaxAge(-1);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }


        return "redirect:/shopping/buyCart.shtml";
    }

}
