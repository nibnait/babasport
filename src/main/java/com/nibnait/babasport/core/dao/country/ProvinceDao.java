package com.nibnait.babasport.core.dao.country;

import java.util.List;

import com.nibnait.babasport.core.bean.country.Province;
import com.nibnait.babasport.core.query.country.ProvinceQuery;

public interface ProvinceDao {

	/**
	 * 添加
	 * @param province
	 */
	public Integer addProvince(Province province);

	/**
	 * 根据主键查找
	 * @param provinceQuery
	 */
	public Province getProvinceByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param provinceQuery
	 */
	public List<Province> getProvincesByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param provinceQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param provinceQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param provinceQuery
	 */
	public Integer updateProvinceByKey(Province province);

	/**
	 * 分页查询
	 * @param provinceQuery
	 */
	public List<Province> getProvinceListWithPage(ProvinceQuery provinceQuery);

	/**
	 * 集合查询
	 * @param provinceQuery
	 */
	public List<Province> getProvinceList(ProvinceQuery provinceQuery);
	
	/**
	 * 总条数
	 * @param provinceQuery
	 */
	public int getProvinceListCount(ProvinceQuery provinceQuery);
}
