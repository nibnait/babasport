package com.nibnait.babasport.core.web;

import com.nibnait.babasport.common.web.session.SessionProvider;
import com.nibnait.babasport.core.bean.user.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理上下文
 * 处理Session
 * 全局
 * Created by nibnait on 2016/5/9.
 */
public class SpringmvcInterceptor implements HandlerInterceptor {

//    public SpringmvcInterceptor() {
//        List<String> list = new ArrayList<String>();//存放一些 无需拦截的URL
//        list.add("/buyer/");
//    }

    private Integer adminId;

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Autowired
    private SessionProvider sessionProvider;
    //常量
    private static final String INTERCEPTOR_URL = "/buyer/";

    //在执行Handler之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        if (adminId == 1) {

            Buyer b = new Buyer();
            b.setUsername("fbb2014");
            sessionProvider.setAttribute(request, Constants.BUYER_SESSION,b,response);

        } else {

            Buyer buyer = (Buyer) sessionProvider.getAttribute(request, Constants.BUYER_SESSION,response);
            boolean isLogin = false;
            if (null != buyer) {
                isLogin = true;
            }
            request.setAttribute("isLogin", isLogin);

            String requestURI = request.getRequestURI();
            if (requestURI.startsWith(INTERCEPTOR_URL)) {
                //必须登陆
                if (null == buyer) {
                    response.sendRedirect("/shopping/login.shtml?returnUrl=" + request.getParameter("returnUrl"));
                    return false;
                }
            }
        }

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
