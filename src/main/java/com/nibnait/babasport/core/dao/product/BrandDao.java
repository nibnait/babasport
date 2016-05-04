package com.nibnait.babasport.core.dao.product;

import com.nibnait.babasport.core.bean.product.Brand;

import java.util.List;

/**
 * 品牌
 * Created by nibnait on 2016/5/4.
 */
public interface BrandDao {

    //List集合
    public List<Brand> getBrandListWithPage(Brand brand);

    //获取总几率数
    public int getBrandCount(Brand brand);
}
