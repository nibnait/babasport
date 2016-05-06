package com.nibnait.babasport.core.controller.admin;

import com.nibnait.babasport.core.bean.product.Brand;
import com.nibnait.babasport.core.query.product.BrandQuery;
import com.nibnait.babasport.core.query.product.ProductQuery;
import com.nibnait.babasport.core.service.product.BrandService;
import com.nibnait.babasport.core.service.product.ProductService;
import com.nibnait.common.page.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 后台商品管理
 * 商品列表
 * 商品添加
 * 商品上架
 * Created by nibnait on 2016/5/6.
 */
@Controller
public class ProductController {

    @Autowired
    BrandService brandService;
    @Autowired
    ProductService productService;


    //商品列表
    @RequestMapping(value = "/product/list.do")
    public String list(Integer pageNo, String name, Integer brandId, Integer isShow, ModelMap model){

        //加载品牌
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setFields("name,id");
        brandQuery.setIsDisplay(1);
        List<Brand> brandList = brandService.getBrandList(brandQuery);
        model.addAttribute("brandList",brandList);


        ProductQuery productQuery = new ProductQuery();
        StringBuilder params = new StringBuilder();
        if (StringUtils.isNotBlank(name)){
            productQuery.setName(name);
            productQuery.setNameLike(true);

            params.append("&name=").append(name);

            //回显查询条件
            model.addAttribute("name",name);
        }

        if (brandId != null){
            productQuery.setBrandId(brandId);

            params.append("&brandId=").append(brandId);

            //回显查询条件
            model.addAttribute("brandId",brandId);
        }

        if (isShow != null){
            productQuery.setIsShow(isShow);
            model.addAttribute("isShow",isShow);
            params.append("&isShow=").append(isShow);
        } else {
            productQuery.setIsShow(0);//默认显示“下架”商品
            model.addAttribute("isShow",0);
            params.append("&isShow=").append(0);
        }
        productQuery.setPageNo(Pagination.cpn(pageNo));
        productQuery.setPageSize(5);

        Pagination pagination = productService.getProductListWithPage(productQuery);
        //setPageView
        String url = "/product/list.do";
        pagination.pageView(url, params.toString());

        model.addAttribute("pagination",pagination);
        return "product/list";
    }


}
