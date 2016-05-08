package com.nibnait.babasport.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.product.Sku;
import com.nibnait.babasport.core.dao.product.SkuDao;
import com.nibnait.babasport.core.query.product.SkuQuery;
/**
 * 最小销售单元事务层
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class SkuServiceImpl implements SkuService {

	@Resource
	private SkuDao skuDao;
	@Resource
	private ColorService colorService;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSku(Sku sku) {
		return skuDao.addSku(sku);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Sku getSkuByKey(Integer id) {
		return skuDao.getSkuByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Sku> getSkusByKeys(List<Integer> idList) {
		return skuDao.getSkusByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return skuDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return skuDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSkuByKey(Sku sku) {
		return skuDao.updateSkuByKey(sku);
	}
	
	@Transactional(readOnly = true)
	public Pagination getSkuListWithPage(SkuQuery skuQuery) {
		Pagination p = new Pagination(skuQuery.getPageNo(),skuQuery.getPageSize(),skuDao.getSkuListCount(skuQuery));
		p.setList(skuDao.getSkuListWithPage(skuQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Sku> getSkuList(SkuQuery skuQuery) {
        List<Sku> skuList = skuDao.getSkuList(skuQuery);
        /**2016-05-07 18:10:29添加 根据colorId填充sku的Color.name*/
        for (Sku sku:skuList){
            sku.setColor(colorService.getColorByKey(sku.getColorId()));
        }

        return skuList;
	}

    public List<Sku> getStock(Integer id) {
        List<Sku> skuList = skuDao.getStock(id);
        for (Sku sku:skuList){
            sku.setColor(colorService.getColorByKey(sku.getColorId()));
        }
        return skuList;
    }

    public void deleteByProductId(Integer id) {
        skuDao.deleteByProductId(id);
    }

    public void deleteByProductIds(List<Integer> ids) {
        skuDao.deleteByProductIds(ids);
    }
}
