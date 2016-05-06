package com.nibnait.babasport.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.user.Buyer;
import com.nibnait.babasport.core.dao.user.BuyerDao;
import com.nibnait.babasport.core.query.user.BuyerQuery;
/**
 * 购买者
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

	@Resource
	BuyerDao buyerDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addBuyer(Buyer buyer) {
		return buyerDao.addBuyer(buyer);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Buyer getBuyerByKey(String id) {
		return buyerDao.getBuyerByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Buyer> getBuyersByKeys(List<String> idList) {
		return buyerDao.getBuyersByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id) {
		return buyerDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<String> idList) {
		return buyerDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateBuyerByKey(Buyer buyer) {
		return buyerDao.updateBuyerByKey(buyer);
	}
	
	@Transactional(readOnly = true)
	public Pagination getBuyerListWithPage(BuyerQuery buyerQuery) {
		Pagination p = new Pagination(buyerQuery.getPageNo(),buyerQuery.getPageSize(),buyerDao.getBuyerListCount(buyerQuery));
		p.setList(buyerDao.getBuyerListWithPage(buyerQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Buyer> getBuyerList(BuyerQuery buyerQuery) {
		return buyerDao.getBuyerList(buyerQuery);
	}
}
