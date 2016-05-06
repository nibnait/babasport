package com.nibnait.babasport.core.service.user;

import java.util.List;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.user.Addr;
import com.nibnait.babasport.core.query.user.AddrQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午01:50:28]
 */
public interface AddrService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addAddr(Addr addr);

	/**
	 * 根据主键查询
	 */
	public Addr getAddrByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Addr> getAddrsByKeys(List<Integer> idList);

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
	public Integer updateAddrByKey(Addr addr);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param addrQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getAddrListWithPage(AddrQuery addrQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param addrQuery
	 *            查询条件
	 * @return
	 */
	public List<Addr> getAddrList(AddrQuery addrQuery);
}
