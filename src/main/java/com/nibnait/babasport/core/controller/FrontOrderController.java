package com.nibnait.babasport.core.controller;

import com.nibnait.babasport.common.web.session.SessionProvider;
import com.nibnait.babasport.core.bean.BuyCart;
import com.nibnait.babasport.core.bean.BuyItem;
import com.nibnait.babasport.core.bean.order.Order;
import com.nibnait.babasport.core.bean.user.Buyer;
import com.nibnait.babasport.core.service.order.OrderService;
import com.nibnait.babasport.core.service.product.SkuService;
import com.nibnait.babasport.core.web.Constants;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 前台提交订单
 * Created by nibnait on 2016/5/10.
 */
@Controller
public class FrontOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private SkuService skuService;
    @Autowired
    private SessionProvider sessionProvider;

    @RequestMapping(value = "/buyer/confirmOrder.shtml")
    public String confirmOrder(Order order, HttpServletRequest request, HttpServletResponse response){

        Buyer buyer = (Buyer) sessionProvider.getAttribute(request, Constants.BUYER_SESSION,response);
        order.setBuyerId(buyer.getUsername());
        BuyCart buyCart = loadBuyCartFromCookie(request);
        //保存订单   订单详情  二张表
        orderService.addOrder(order,buyCart);

        //清空购物车
        Cookie cookie = new Cookie(Constants.BUYCART_COOKIE,null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "product/confirmOrder";
    }




    private BuyCart loadBuyCartFromCookie(HttpServletRequest request) {
        BuyCart buyCart = new BuyCart();
        //判断Cookie中有没有购物车
        Cookie[] cookies = request.getCookies();
        buyCart = readBuyCartFromCookie(buyCart,cookies);
        //将购物车装满
        buyCart = loadCart(buyCart);
        return buyCart;
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
