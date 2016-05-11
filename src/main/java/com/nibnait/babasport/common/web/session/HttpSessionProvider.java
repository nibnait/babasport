package com.nibnait.babasport.common.web.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by nibnait on 2016/5/8.
 */
public class HttpSessionProvider implements SessionProvider{

    public void setAttribute(HttpServletRequest request, String name, Serializable value,HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute(name,value);
    }

    public Serializable getAttribute(HttpServletRequest request, String name,HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session!=null) {
            return (Serializable) session.getAttribute(name);
        }
        return null;
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        if (session!=null) {
            session.invalidate();

        // 根据JSESSIONID 清除对应的Cookie
            //expiry 单位 秒
            //      默认是 -1 关闭浏览器就没了
            //             0  马上消失
            String sessionId = session.getId();
            Cookie cookie = new Cookie("JSESSIONID",sessionId);
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }


    }

    public String getSessionId(HttpServletRequest request,HttpServletResponse response) {
        return request.getSession().getId();
    }
}
