package com.nibnait.babasport.core.service;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by nibnait on 2016/5/8.
 */
public class BaseServiceImpl implements ServletContextAware, BaseService {

    private ServletContext servletContext;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    //获取当前目录的realpath
    public String getPath(String name){
        return this.servletContext.getRealPath(name);
    }
}
