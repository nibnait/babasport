package com.nibnait.babasport.core.service.product;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.nibnait.babasport.common.web.FormatDateUtils;
import com.nibnait.babasport.core.bean.product.Img;
import com.nibnait.babasport.core.bean.product.Sku;
import com.nibnait.babasport.core.query.product.ImgQuery;
import com.sun.glass.ui.Size;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.product.Product;
import com.nibnait.babasport.core.dao.product.ProductDao;
import com.nibnait.babasport.core.query.product.ProductQuery;
/**
 * 商品事务层
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource
	ProductDao productDao;
	@Resource
	ImgService imgService;
	@Resource
	SkuService skuService;
	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProduct(Product product) {

		product.setNo(FormatDateUtils.dateToString3(new Date()));
		product.setCreateTime(new Date());
		//**保存商品**************begin*************/
		//需useGeneratedKeys自动生成商品id，返回的i是影响到的行数。
		Integer i 	= productDao.addProduct(product);

		/**保存图片**************begin*************/
		product.getImg().setProductId(product.getId());
		product.getImg().setIsDef(1);
		imgService.addImg(product.getImg());

		/**保存sku**************begin*************/
		Sku sku = new Sku();
		sku.setProductId(product.getId());
		sku.setDeliveFee(10.00);//运费
		sku.setSkuPrice(0.00);//售价
		sku.setMarketPrice(0.00);//市场价
		sku.setStockInventory(0);//库存
		sku.setSkuUpperLimit(0);//购买限制
		sku.setCreateTime(new Date());//添加时间
		sku.setLastStatus(1);//是 最新
		sku.setSkuType(1);//是普通商品（不是赠品）
		for(String color : product.getColor().split(",")){
			sku.setColorId(Integer.parseInt(color));
			for(String size : product.getSize().split(",")) {
				sku.setSize(size);
				skuService.addSku(sku);//**********保存*********************
			}
		}

		return i;
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Product getProductByKey(Integer id) {
		return productDao.getProductByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductsByKeys(List<Integer> idList) {
		return productDao.getProductsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return productDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return productDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProductByKey(Product product) {
		return productDao.updateProductByKey(product);
	}
	
	@Transactional(readOnly = true)
	public Pagination getProductListWithPage(ProductQuery productQuery) {
		Pagination p = new Pagination(productQuery.getPageNo(),productQuery.getPageSize(),productDao.getProductListCount(productQuery));
		List<Product> products = productDao.getProductListWithPage(productQuery);
		/**2016-05-07 08:05:47添加 根据productId查找对应的默认图片，设置product.setImg的url*/
		for(Product product:products){
			ImgQuery imgQuery = new ImgQuery();
			imgQuery.setProductId(product.getId());
			imgQuery.setIsDef(1);
			List<Img> imgs = imgService.getImgList(imgQuery);
			product.setImg(imgs.get(0));
		}
		p.setList(products);
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductList(ProductQuery productQuery) {
		return productDao.getProductList(productQuery);
	}
}
