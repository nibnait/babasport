package com.nibnait.babasport.core.dao.product;

import java.util.List;

import com.nibnait.babasport.core.bean.product.Feature;
import com.nibnait.babasport.core.query.product.FeatureQuery;

public interface FeatureDao {

	/**
	 * 添加
	 * @param feature
	 */
	public Integer addFeature(Feature feature);

	/**
	 * 根据主键查找
	 * @param featureQuery
	 */
	public Feature getFeatureByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param featureQuery
	 */
	public List<Feature> getFeaturesByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param featureQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param featureQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param featureQuery
	 */
	public Integer updateFeatureByKey(Feature feature);

	/**
	 * 分页查询
	 * @param featureQuery
	 */
	public List<Feature> getFeatureListWithPage(FeatureQuery featureQuery);

	/**
	 * 集合查询
	 * @param featureQuery
	 */
	public List<Feature> getFeatureList(FeatureQuery featureQuery);
	
	/**
	 * 总条数
	 * @param featureQuery
	 */
	public int getFeatureListCount(FeatureQuery featureQuery);
}
