package com.nibnait.babasport.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台商品管理
 * 商品列表
 * 商品添加
 * 商品上架
 * Created by nibnait on 2016/5/6.
 */
@Controller
public class ProductController {

    //商品列表
    @RequestMapping(value = "/product/list.do")
    public String list(Integer pageNo, String name, Integer brandId, Integer isShow, ModelMap model){



        return "product/list";
    }


}
