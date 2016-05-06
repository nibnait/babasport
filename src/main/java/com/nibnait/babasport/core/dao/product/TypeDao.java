package com.nibnait.babasport.core.dao.product;

import java.util.List;

import com.nibnait.babasport.core.bean.product.Type;
import com.nibnait.babasport.core.query.product.TypeQuery;

public interface TypeDao {

	/**
	 * 添加
	 * @param type
	 */
	public Integer addType(Type type);

	/**
	 * 根据主键查找
	 * @param typeQuery
	 */
	public Type getTypeByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param typeQuery
	 */
	public List<Type> getTypesByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param typeQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param typeQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param typeQuery
	 */
	public Integer updateTypeByKey(Type type);

	/**
	 * 分页查询
	 * @param typeQuery
	 */
	public List<Type> getTypeListWithPage(TypeQuery typeQuery);

	/**
	 * 集合查询
	 * @param typeQuery
	 */
	public List<Type> getTypeList(TypeQuery typeQuery);
	
	/**
	 * 总条数
	 * @param typeQuery
	 */
	public int getTypeListCount(TypeQuery typeQuery);
}
