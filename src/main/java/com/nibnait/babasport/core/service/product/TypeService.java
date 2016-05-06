package com.nibnait.babasport.core.service.product;

import java.util.List;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.product.Type;
import com.nibnait.babasport.core.query.product.TypeQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午01:50:28]
 */
public interface TypeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addType(Type type);

	/**
	 * 根据主键查询
	 */
	public Type getTypeByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Type> getTypesByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTypeByKey(Type type);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param typeQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getTypeListWithPage(TypeQuery typeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param typeQuery
	 *            查询条件
	 * @return
	 */
	public List<Type> getTypeList(TypeQuery typeQuery);
}
