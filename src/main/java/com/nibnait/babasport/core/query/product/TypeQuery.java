package com.nibnait.babasport.core.query.product;

import java.util.ArrayList;
import java.util.List;

import com.nibnait.babasport.core.query.BaseQuery;

/**
 * 商品类型条件对象
 * @author lixu
 * @Date [2014-3-28 下午05:58:00]
 */
public class TypeQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public TypeQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String name;
	public String getName() {
		return name;
	}
	public TypeQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public TypeQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
	private Integer parentId;
	public Integer getParentId() {
		return parentId;
	}
	public TypeQuery setParentId(Integer parentId) {
		this.parentId = parentId;
		return this;
	}
	private String note;
	public String getNote() {
		return note;
	}
	public TypeQuery setNote(String note) {
		this.note = note;
		return this;
	}
	private boolean noteLike;
	public TypeQuery setNoteLike(boolean isLike) {
		this.noteLike = isLike;
		return this;
	}
	private Integer isDisplay;
	public Integer getIsDisplay() {
		return isDisplay;
	}
	public TypeQuery setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
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
	public TypeQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：name
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public TypeQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：parent_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public TypeQuery orderbyParentId(boolean isAsc) {
		orderFields.add(new OrderField("parent_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：note
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public TypeQuery orderbyNote(boolean isAsc) {
		orderFields.add(new OrderField("note", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：is_display
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public TypeQuery orderbyIsDisplay(boolean isAsc) {
		orderFields.add(new OrderField("is_display", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
