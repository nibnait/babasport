package com.nibnait.babasport;

import com.nibnait.babasport.common.junit.SpringJunitTest;
import com.nibnait.babasport.core.bean.TestTb;
import com.nibnait.babasport.core.bean.product.Brand;
import com.nibnait.babasport.core.query.product.BrandQuery;
import com.nibnait.babasport.core.service.TestTbService;
import com.nibnait.babasport.core.service.product.BrandService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 测试
 * Created by nibnait on 2016/5/4.
 */
public class TestBrand extends SpringJunitTest{

    @Autowired
    private BrandService brandService;

    @Test
    public void testGet(){

        BrandQuery brandQuery = new BrandQuery();

//        brandQuery.setFields("id");
//        brandQuery.setNameLike(true);
//        brandQuery.setName("金");
        brandQuery.orderbyId(false);
        brandQuery.setPageNo(2);
        brandQuery.setPageSize(2);

        List<Brand> brands = brandService.getBrandList(brandQuery);

        for (Brand b : brands) {
            System.out.println(b);
        }
    }

}
