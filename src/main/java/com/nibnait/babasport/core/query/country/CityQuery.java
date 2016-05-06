package com.nibnait.babasport.core.query.country;

import java.util.ArrayList;
import java.util.List;

import com.nibnait.babasport.core.query.BaseQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午05:58:00]
 */
public class CityQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public CityQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String code;
	public String getCode() {
		return code;
	}
	public CityQuery setCode(String code) {
		this.code = code;
		return this;
	}
	private boolean codeLike;
	public CityQuery setCodeLike(boolean isLike) {
		this.codeLike = isLike;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public CityQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public CityQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
	private String province;
	public String getProvince() {
		return province;
	}
	public CityQuery setProvince(String province) {
		this.province = province;
		return this;
	}
	private boolean provinceLike;
	public CityQuery setProvinceLike(boolean isLike) {
		this.provinceLike = isLike;
		return this;
	}
	/**
	 * ==============================批量查询时的Order条件顺序设置==========================
	 * ========
	 **/
	 	public class OrderField {
		public OrderField(String fieldName, String order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		private String fieldName;
		private String order;

		public String getFieldName() {
			return fieldName;
		}
		public OrderField setFieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
		public String getOrder() {
			return order;
		}
		public OrderField setOrder(String order) {
			this.order = order;
			return this;
		}
	}
		/**
	 * ==============================批量查询时的Order条件顺序设置==========================
	 * ========
	 **/
	/** 排序列表字段 **/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	/**
	 * 设置排序按属性：id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public CityQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：code
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public CityQuery orderbyCode(boolean isAsc) {
		orderFields.add(new OrderField("code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：name
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public CityQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：province
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public CityQuery orderbyProvince(boolean isAsc) {
		orderFields.add(new OrderField("province", isAsc ? "ASC" : "DESC"));
		return this;
	}

}
