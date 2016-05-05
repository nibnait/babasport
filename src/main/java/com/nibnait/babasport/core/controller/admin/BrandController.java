package com.nibnait.babasport.core.controller.admin;

import com.nibnait.babasport.core.bean.product.Brand;
import com.nibnait.babasport.core.service.product.BrandService;
import com.nibnait.common.page.Paginable;
import com.nibnait.common.page.Pagination;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌模块
 * Created by nibnait on 2016/5/4.
 */
@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    //品牌列表页面
    @RequestMapping(value = "/brand/list.do")
    public String list(String name, Integer isDisplay, Integer pageNo, ModelMap model){
        StringBuilder params = new StringBuilder();
        Brand brand = new Brand();
        if (name != null && StringUtils.isNotBlank(name)) {
            brand.setName(name);
            params.append("name=").append(name).append("&");
        }
        if (isDisplay != null) {
            brand.setIsDisplay(isDisplay);
            params.append("isDisplay=").append(isDisplay);
        }else {
            brand.setIsDisplay(1);
            params.append("&").append("isDisplay=").append(1);
        }

        brand.setPageNo(Pagination.cpn(pageNo));//如果页号为空或小于1 将其置为1
        brand.setPageSize(5);

        //分页对象
        Pagination pagination = brandService.getBrandListWithPage(brand);
        String url = "/brand/list.do";
        pagination.pageView(url, params.toString()); //分页展示

        model.addAttribute("pagination", pagination);
        model.addAttribute("name",name);
        model.addAttribute("isDisplay",isDisplay);


        return "brand/list";
    }

    //跳转品牌添加页面
    @RequestMapping(value = "/brand/toAdd.do")
    public String toAdd(Brand brand){
        return "brand/add";
    }

    //添加品牌
    @RequestMapping(value = "/brand/add.do")
    public String add(Brand brand){
        try {
            brandService.addBrand(brand);
        }catch (Exception e){
            // TODO: 2016/5/5 添加失败，将已传到服务器的图片 删除！！
            e.printStackTrace();//最后 应该直接抛出个 运行时异常
        }

        return "redirect:/brand/list.do";
    }

    //删除一个品牌
    @RequestMapping(value = "/brand/delete.do")
    public String delete(Integer id, String name, Integer isDisplay, ModelMap model){

        brandService.deleteBrandById(id);
        if (StringUtils.isNotBlank(name)) {
            model.addAttribute("name", name);
        }
        if (isDisplay!=null){
            model.addAttribute("isDisplay", isDisplay);
        }
        return "redirect:/brand/list.do";
    }
    //删除多个品牌
    @RequestMapping(value = "/brand/deletes.do")
    public String deletes(Integer[] ids, String name, Integer isDisplay, ModelMap model){

        brandService.deleteBrandByIds(ids);
        if (StringUtils.isNotBlank(name)) {
            model.addAttribute("name", name);
        }
        if (isDisplay!=null){
            model.addAttribute("isDisplay", isDisplay);
        }
        return "redirect:/brand/list.do";
    }

    //跳转到Eidt页面
    @RequestMapping(value = "/brand/toEdit.do")
    public String toEdit(Integer id, ModelMap model){
        Brand brand= brandService.getBrandById(id);
        model.addAttribute("brand", brand);
        return "brand/edit";
    }

    @RequestMapping(value = "/brand/edit.do")
    public String edit(Brand brand){
        brandService.updateBrandById(brand);

        return "redirect:/brand/list.do";
    }



}
