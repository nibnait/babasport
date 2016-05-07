package com.nibnait.babasport.common.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异步返回各种格式
 * json
 * xml
 * text
 * Created by nibnait on 2016/5/4.
 */
public class ResponseUtils {
    //发送内容
    public static void render(HttpServletResponse response, String contentType, String text){
        response.setContentType(contentType);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //发送的是JSON
    public static void renderJson(HttpServletResponse response,String text){
        render(response, "application/json;charset=UTF-8", text);
    }
    //发送xml
    public static void renderXml(HttpServletResponse response,String text){
        render(response, "text/xml;charset=UTF-8", text);
    }
    //发送text
    public static void renderText(HttpServletResponse response,String text){
        render(response, "text/plain;charset=UTF-8", text);
    }
}
