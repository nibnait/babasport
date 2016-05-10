package com.nibnait.babasport.core.service.product;

import com.nibnait.babasport.core.bean.product.Brand;
import com.nibnait.babasport.core.dao.product.BrandDao;
import com.nibnait.babasport.core.query.product.BrandQuery;
import com.nibnait.common.page.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**]
 * 品牌事物层
 * Created by nibnait on 2016/5/4.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Resource
    BrandDao brandDao;

    public List<Brand> getBrandList(BrandQuery brandQuery) {
        return brandDao.getBrandList(brandQuery);
    }

    @Transactional(readOnly = true)
    public Pagination getBrandListWithPage(Brand brand){
        //1：起始页
        //2:pageSize
        //3:totalRows
        Pagination pagination = new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));

        pagination.setList(brandDao.getBrandListWithPage(brand));

        return pagination;
    }


    public void addBrand(Brand brand) {
        brandDao.addBrand(brand);
    }


    public void deleteBrandByKeys(Integer[] ids) {
        brandDao.deleteBrandByKeys(ids);
    }
    public void deleteBrandByKey(Integer id) {
        brandDao.deleteBrandByKey(id);
    }

    public void updateBrandByKey(Brand brand) {
        brandDao.updateBrandByKey(brand);
    }

    public Brand getBrandByKey(Integer id){
        return brandDao.getBrandByKey(id);
    }
}
