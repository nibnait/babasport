package com.nibnait.babasport.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.product.Type;
import com.nibnait.babasport.core.dao.product.TypeDao;
import com.nibnait.babasport.core.query.product.TypeQuery;
/**
 * 商品类型
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Resource
	TypeDao typeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addType(Type type) {
		return typeDao.addType(type);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Type getTypeByKey(Integer id) {
		return typeDao.getTypeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypesByKeys(List<Integer> idList) {
		return typeDao.getTypesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return typeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return typeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTypeByKey(Type type) {
		return typeDao.updateTypeByKey(type);
	}
	
	@Transactional(readOnly = true)
	public Pagination getTypeListWithPage(TypeQuery typeQuery) {
		Pagination p = new Pagination(typeQuery.getPageNo(),typeQuery.getPageSize(),typeDao.getTypeListCount(typeQuery));
		p.setList(typeDao.getTypeListWithPage(typeQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypeList(TypeQuery typeQuery) {
		return typeDao.getTypeList(typeQuery);
	}
}
