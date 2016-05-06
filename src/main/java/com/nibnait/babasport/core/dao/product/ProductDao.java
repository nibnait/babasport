package com.nibnait.babasport.core.dao.product;

import java.util.List;

import com.nibnait.babasport.core.bean.product.Product;
import com.nibnait.babasport.core.query.product.ProductQuery;

public interface ProductDao {

	/**
	 * 添加
	 * @param product
	 */
	public Integer addProduct(Product product);

	/**
	 * 根据主键查找
	 * @param productQuery
	 */
	public Product getProductByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param productQuery
	 */
	public List<Product> getProductsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param productQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param productQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param productQuery
	 */
	public Integer updateProductByKey(Product product);

	/**
	 * 分页查询
	 * @param productQuery
	 */
	public List<Product> getProductListWithPage(ProductQuery productQuery);

	/**
	 * 集合查询
	 * @param productQuery
	 */
	public List<Product> getProductList(ProductQuery productQuery);
	
	/**
	 * 总条数
	 * @param productQuery
	 */
	public int getProductListCount(ProductQuery productQuery);
}
