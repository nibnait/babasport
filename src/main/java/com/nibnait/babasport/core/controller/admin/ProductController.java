package com.nibnait.babasport.core.controller.admin;

import com.nibnait.babasport.core.bean.product.*;
import com.nibnait.babasport.core.query.product.*;
import com.nibnait.babasport.core.service.product.*;
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
    @Autowired
    TypeService typeService;
    @Autowired
    FeatureService featureService;
    @Autowired
    ColorService colorService;


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

        productQuery.orderbyBrandId(false);

        Pagination pagination = productService.getProductListWithPage(productQuery);
        //setPageView
        String url = "/product/list.do";
        pagination.pageView(url, params.toString());

        model.addAttribute("pagination",pagination);
        return "product/list";
    }

    //跳转到 添加页面
    @RequestMapping(value = "/product/toAdd.do")
    public String toAdd(ModelMap model){

        //加载类型
        TypeQuery typeQuery = new TypeQuery();
        typeQuery.setFields("id,name");
        typeQuery.setIsDisplay(1);
        typeQuery.setParentId(0);   //(父Id不等于0的)
        List<Type> typeList = typeService.getTypeList(typeQuery);
        model.addAttribute("typeList",typeList);

        //加载品牌
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setFields("id,name");
        brandQuery.setIsDisplay(1);
        List<Brand> brandList = brandService.getBrandList(brandQuery);
        model.addAttribute("brandList",brandList);

        //加载商品属性
        FeatureQuery featureQuery = new FeatureQuery();
        List<Feature> featureList = featureService.getFeatureList(featureQuery);
        model.addAttribute("featureList",featureList);
        
        //加载颜色
        ColorQuery colorQuery = new ColorQuery();
        colorQuery.setParentId(0);
        List<Color> colorList = colorService.getColorList(colorQuery);
        model.addAttribute("colorList",colorList);

        return "/product/add";
    }


    //添加页面
    @RequestMapping(value = "/product/add.do")
    public String add(Product product, Img img){

        product.setImg(img);
        productService.addProduct(product);
        return "redirect:/product/list.do";
    }


}
