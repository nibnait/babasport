package com.nibnait.babasport.core.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试
 * Created by nibnait on 2016/5/4.
 */
@Controller
public class CenterController {

    @RequestMapping(value = "/test/springmvc.do", method = RequestMethod.POST)
    public String test(String name, Date birthday){

        System.out.printf("");
        return "";
    }


}

