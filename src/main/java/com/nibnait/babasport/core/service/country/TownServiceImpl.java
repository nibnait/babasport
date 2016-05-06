package com.nibnait.babasport.core.service.country;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.country.Town;
import com.nibnait.babasport.core.dao.country.TownDao;
import com.nibnait.babasport.core.query.country.TownQuery;
/**
 * 县/区
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class TownServiceImpl implements TownService {

	@Resource
	TownDao townDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addTown(Town town) {
		return townDao.addTown(town);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Town getTownByKey(Integer id) {
		return townDao.getTownByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Town> getTownsByKeys(List<Integer> idList) {
		return townDao.getTownsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return townDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return townDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTownByKey(Town town) {
		return townDao.updateTownByKey(town);
	}
	
	@Transactional(readOnly = true)
	public Pagination getTownListWithPage(TownQuery townQuery) {
		Pagination p = new Pagination(townQuery.getPageNo(),townQuery.getPageSize(),townDao.getTownListCount(townQuery));
		p.setList(townDao.getTownListWithPage(townQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Town> getTownList(TownQuery townQuery) {
		return townDao.getTownList(townQuery);
	}
}
