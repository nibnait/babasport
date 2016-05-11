package com.nibnait.babasport.common.web.session;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 远程Session
 * 存放在Memcached缓存服务器中的Session
 * Created by nibnait on 2016/5/11.
 */
public class CacheSessionProvider  implements  SessionProvider{

    @Autowired
    private MemCachedClient memCachedClient;

    private int expiry = 30;//【分】

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public void setAttribute(HttpServletRequest request, String name, Serializable value, HttpServletResponse response) {

        Map<String, Serializable> session = new HashMap<String, Serializable>();
        session.put(name,value);

        memCachedClient.set(getSessionId(request,response),session,expiry*60);

    }

    public Serializable getAttribute(HttpServletRequest request, String name,HttpServletResponse response) {

        Map<String, Serializable> session = (Map<String, Serializable>) memCachedClient.get(getSessionId(request, response));

        if (session !=null) {
            return session.get(name);
        }
        return null;
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {

        if(memCachedClient.keyExists(getSessionId(request, response))){
            memCachedClient.delete(getSessionId(request, response));
        }
        //TODO 清理Cookie


    }

    public String getSessionId(HttpServletRequest request,HttpServletResponse response) {

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if (cookie.getName().equals("JSESSIONID")){
                return cookie.getValue();
            }
        }
        //new一个，带有JSESSIONID的Cookie
        String sessionId = UUID.randomUUID().toString().replaceAll("-","");
        Cookie cookie = new Cookie("JSESSIONID",sessionId);
        response.addCookie(cookie);

        return sessionId;
    }
}
