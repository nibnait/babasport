package com.nibnait.babasport.core.service.country;

import java.util.List;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.country.Province;
import com.nibnait.babasport.core.query.country.ProvinceQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午01:50:28]
 */
public interface ProvinceService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addProvince(Province province);

	/**
	 * 根据主键查询
	 */
	public Province getProvinceByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Province> getProvincesByKeys(List<Integer> idList);

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
	public Integer updateProvinceByKey(Province province);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param provinceQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getProvinceListWithPage(ProvinceQuery provinceQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param provinceQuery
	 *            查询条件
	 * @return
	 */
	public List<Province> getProvinceList(ProvinceQuery provinceQuery);
}
