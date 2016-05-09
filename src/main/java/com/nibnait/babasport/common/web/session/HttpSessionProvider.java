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

    public void setAttribute(HttpServletRequest request, String name, Serializable value) {
        HttpSession session = request.getSession();
        session.setAttribute(name,value);
    }

    public Serializable getAttribute(HttpServletRequest request, String name) {
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
//            String sessionId = session.getId();
//            Cookie cookie = new Cookie("JSESSIONID",sessionId);
//            cookie.setPath();
//            cookie.setMaxAge(0);
//            response.addCookie(cookie);
        }


    }

    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }
}
