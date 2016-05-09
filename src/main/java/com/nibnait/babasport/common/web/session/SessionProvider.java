package com.nibnait.babasport.common.web.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * Created by nibnait on 2016/5/8.
 */
public interface SessionProvider {

    public void setAttribute(HttpServletRequest request, String name, Serializable value);

    public Serializable getAttribute(HttpServletRequest request,String name);

    public void logout(HttpServletRequest request, HttpServletResponse response);

    public String getSessionId(HttpServletRequest request);

}
