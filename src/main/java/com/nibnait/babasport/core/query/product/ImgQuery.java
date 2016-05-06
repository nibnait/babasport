package com.nibnait.babasport.core.query.product;

import java.util.ArrayList;
import java.util.List;

import com.nibnait.babasport.core.query.BaseQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午05:58:00]
 */
public class ImgQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ImgQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private Integer productId;
	public Integer getProductId() {
		return productId;
	}
	public ImgQuery setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	private String url;
	public String getUrl() {
		return url;
	}
	public ImgQuery setUrl(String url) {
		this.url = url;
		return this;
	}
	private boolean urlLike;
	public ImgQuery setUrlLike(boolean isLike) {
		this.urlLike = isLike;
		return this;
	}
	private Integer isDef;
	public Integer getIsDef() {
		return isDef;
	}
	public ImgQuery setIsDef(Integer isDef) {
		this.isDef = isDef;
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
	public ImgQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：product_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public ImgQuery orderbyProductId(boolean isAsc) {
		orderFields.add(new OrderField("product_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：url
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public ImgQuery orderbyUrl(boolean isAsc) {
		orderFields.add(new OrderField("url", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：is_def
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public ImgQuery orderbyIsDef(boolean isAsc) {
		orderFields.add(new OrderField("is_def", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
