package com.nibnait.babasport.core.controller.admin;

import com.nibnait.babasport.common.web.ResponseUtils;
import com.nibnait.babasport.core.bean.product.Sku;
import com.nibnait.babasport.core.query.product.SkuQuery;
import com.nibnait.babasport.core.service.product.SkuService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 库存管理
 * 修改库存
 * Created by nibnait on 2016/5/7.
 */
@Controller
public class SkuController {

    @Autowired
    SkuService skuService;

    @RequestMapping(value = "/sku/list.do")
    public String list(Integer productId, String pno, ModelMap model){

        //商品编号回显
        model.addAttribute("pno",pno);

        //通过productId获得sku集合
        SkuQuery skuQuery = new SkuQuery();
        skuQuery.setProductId(productId);
        List<Sku> skuList = skuService.getSkuList(skuQuery);
        model.addAttribute("skuList",skuList);

        return "sku/list";
    }


    @RequestMapping(value = "/sku/add.do")
    public void add(Sku sku ,HttpServletResponse response){

        skuService.updateSkuByKey(sku);

        JSONObject jo = new JSONObject();
        jo.put("message", "保存成功!");

        ResponseUtils.renderJson(response, jo.toString());
    }

}
