package com.nibnait.babasport.core.query.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nibnait.babasport.core.query.BaseQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午05:58:00]
 */
public class OrderQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public OrderQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private String oid;
	public String getOid() {
		return oid;
	}
	public OrderQuery setOid(String oid) {
		this.oid = oid;
		return this;
	}
	private boolean oidLike;
	public OrderQuery setOidLike(boolean isLike) {
		this.oidLike = isLike;
		return this;
	}
	private Double deliverFee;
	public Double getDeliverFee() {
		return deliverFee;
	}
	public OrderQuery setDeliverFee(Double deliverFee) {
		this.deliverFee = deliverFee;
		return this;
	}
	private Double payableFee;
	public Double getPayableFee() {
		return payableFee;
	}
	public OrderQuery setPayableFee(Double payableFee) {
		this.payableFee = payableFee;
		return this;
	}
	private Double totalPrice;
	public Double getTotalPrice() {
		return totalPrice;
	}
	public OrderQuery setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}
	private Integer paymentWay;
	public Integer getPaymentWay() {
		return paymentWay;
	}
	public OrderQuery setPaymentWay(Integer paymentWay) {
		this.paymentWay = paymentWay;
		return this;
	}
	private Integer paymentCash;
	public Integer getPaymentCash() {
		return paymentCash;
	}
	public OrderQuery setPaymentCash(Integer paymentCash) {
		this.paymentCash = paymentCash;
		return this;
	}
	private Integer delivery;
	public Integer getDelivery() {
		return delivery;
	}
	public OrderQuery setDelivery(Integer delivery) {
		this.delivery = delivery;
		return this;
	}
	private Integer isConfirm;
	public Integer getIsConfirm() {
		return isConfirm;
	}
	public OrderQuery setIsConfirm(Integer isConfirm) {
		this.isConfirm = isConfirm;
		return this;
	}
	private Integer isPaiy;
	public Integer getIsPaiy() {
		return isPaiy;
	}
	public OrderQuery setIsPaiy(Integer isPaiy) {
		this.isPaiy = isPaiy;
		return this;
	}
	private Integer state;
	public Integer getState() {
		return state;
	}
	public OrderQuery setState(Integer state) {
		this.state = state;
		return this;
	}
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public OrderQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	private String note;
	public String getNote() {
		return note;
	}
	public OrderQuery setNote(String note) {
		this.note = note;
		return this;
	}
	private boolean noteLike;
	public OrderQuery setNoteLike(boolean isLike) {
		this.noteLike = isLike;
		return this;
	}
	private String buyerId;
	public String getBuyerId() {
		return buyerId;
	}
	public OrderQuery setBuyerId(String buyerId) {
		this.buyerId = buyerId;
		return this;
	}
	private boolean buyerIdLike;
	public OrderQuery setBuyerIdLike(boolean isLike) {
		this.buyerIdLike = isLike;
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
	public OrderQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：oid
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyOid(boolean isAsc) {
		orderFields.add(new OrderField("oid", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：deliver_fee
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyDeliverFee(boolean isAsc) {
		orderFields.add(new OrderField("deliver_fee", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：payable_fee
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyPayableFee(boolean isAsc) {
		orderFields.add(new OrderField("payable_fee", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：total_price
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyTotalPrice(boolean isAsc) {
		orderFields.add(new OrderField("total_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：payment_way
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyPaymentWay(boolean isAsc) {
		orderFields.add(new OrderField("payment_way", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：payment_cash
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyPaymentCash(boolean isAsc) {
		orderFields.add(new OrderField("payment_cash", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：delivery
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyDelivery(boolean isAsc) {
		orderFields.add(new OrderField("delivery", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：isConfirm
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyIsConfirm(boolean isAsc) {
		orderFields.add(new OrderField("isConfirm", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：is_paiy
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyIsPaiy(boolean isAsc) {
		orderFields.add(new OrderField("is_paiy", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：state
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyState(boolean isAsc) {
		orderFields.add(new OrderField("state", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：note
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyNote(boolean isAsc) {
		orderFields.add(new OrderField("note", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：buyer_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public OrderQuery orderbyBuyerId(boolean isAsc) {
		orderFields.add(new OrderField("buyer_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
