package com.nibnait.babasport.core.service.order;

import java.util.List;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.order.Detail;
import com.nibnait.babasport.core.query.order.DetailQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午01:50:28]
 */
public interface DetailService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addDetail(Detail detail);

	/**
	 * 根据主键查询
	 */
	public Detail getDetailByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Detail> getDetailsByKeys(List<Integer> idList);

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
	public Integer updateDetailByKey(Detail detail);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param detailQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getDetailListWithPage(DetailQuery detailQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param detailQuery
	 *            查询条件
	 * @return
	 */
	public List<Detail> getDetailList(DetailQuery detailQuery);
}
