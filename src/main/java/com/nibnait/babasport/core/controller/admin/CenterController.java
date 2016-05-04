package com.nibnait.babasport.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * 测试
 * Created by nibnait on 2016/5/4.
 */
@Controller
@RequestMapping(value = "/control")
public class CenterController {

    @RequestMapping(value = "/test/springmvc.do", method = RequestMethod.POST)
    public String test(String name, Date birthday){

        System.out.printf("");
        return "";
    }


    //跳转入口页面
    @RequestMapping(value = "/index.do")
    public String index(){
        return "index";
    }

    //跳转头页面
    @RequestMapping(value = "/top.do")
    public String top(){
        return "top";
    }

    //跳转身体页面
    @RequestMapping(value = "/main.do")
    public String main(){
        return "main";
    }

    //跳转左页面
    @RequestMapping(value = "/left.do")
    public String left(){
        return "left";
    }

    //跳转右页面
    @RequestMapping(value = "/right.do")
    public String right(){
        return "right";
    }

}

