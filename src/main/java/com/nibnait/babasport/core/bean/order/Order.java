package com.nibnait.babasport.core.bean.order;

import java.util.*;
import java.io.Serializable;

/**
 * 订单  --主
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class Order implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String oid;
	private Double deliverFee;
	private Double payableFee;
	private Double totalPrice;
	private Integer paymentWay;
	private Integer paymentCash;
	private Integer delivery;
	private Integer isConfirm;
	private Integer isPaiy;
	private Integer state;
	private Date createDate;
	private String note;
	private String buyerId;
	
	/** 特殊处理字段   */
	/** 支付方式           */
	public String getPaymentWayName() {
		switch (paymentWay) {
			case 0:  return "货到到付";
			case 1:  return "在线支付";
			case 2:  return "公司转帐";
			case 3:  return "邮局汇款";
			default: return "";
		}
	}
	/** 支付要求     必须是货到付款时  才会有支付要求 分为 0:现金 1:POS机       */
	public String getPaymentCashName() {
		if(null == paymentCash) return null;
		
		switch (paymentCash) {
			case 0:  return "现金";
			case 1:  return "POS机";
			default: return "";
		}
	}
	/** 支付状态        //支付状态 :0到付,1待付款,2已付款,3待退款,4退款成功,5退款失败  */
	public String getIsPaiyName() {
		switch (isPaiy) {
			case 0:  return "货到到付";
			case 1:  return "待付款";
			case 2:  return "已付款";
			case 3:  return "待退款";
			case 4:  return "退款成功";
			case 5:  return "退款失败";
			default: return "";
		}
	}
	/** 订单状态        //订单状态 0:提交订单 1:仓库配货 2:商品出库 3:等待收货 4:完成 5:待退货 6已退货 7已取消  */
	public String getStateName() {
		switch (state) {
			case 0:  return "提交订单";
			case 1:  return "仓库配货";
			case 2:  return "商品出库";
			case 3:  return "等待收货";
			case 4:  return "已完成";
			case 5:  return "待退货";
			case 6:  return "已退货";
			case 7:  return "已取消";
			default: return "";
		}
	}
	/** 送货时间    //  1:工作日，双休日，假日均可送货  2:只双休日，假日送货   3:只工作日送货（双休日，节假日不送）         */
	public String getDeliveryName() {
		switch (delivery) {
		case 1:  return "工作日，双休日，假日均可送货";
		case 2:  return "只双休日，假日送货";
		case 3:  return "只工作日送货（双休日，节假日不送）";
		default: return "";
		}
	}
	/** 电话确认     1:是   0:否          */
	public String getIsConfirmName() {
		switch (isConfirm) {
			case 0:  return "否";
			case 1:  return "是";
			default: return "";
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Double getDeliverFee() {
		return deliverFee;
	}
	public void setDeliverFee(Double deliverFee) {
		this.deliverFee = deliverFee;
	}
	public Double getPayableFee() {
		return payableFee;
	}
	public void setPayableFee(Double payableFee) {
		this.payableFee = payableFee;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setPaymentWay(Integer paymentWay) {
		this.paymentWay = paymentWay;
	}
	public Integer getPaymentWay() {
		return paymentWay;
	}
	public Integer getPaymentCash() {
		return paymentCash;
	}
	public Integer getIsPaiy() {
		return isPaiy;
	}
	public Integer getState() {
		return state;
	}
	public void setPaymentCash(Integer paymentCash) {
		this.paymentCash = paymentCash;
	}
	public Integer getDelivery() {
		return delivery;
	}
	public void setDelivery(Integer delivery) {
		this.delivery = delivery;
	}
	public Integer getIsConfirm() {
		return isConfirm;
	}
	public void setIsConfirm(Integer isConfirm) {
		this.isConfirm = isConfirm;
	}
	public void setIsPaiy(Integer isPaiy) {
		this.isPaiy = isPaiy;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", oid=" + oid + ", deliverFee="
				+ deliverFee + ", payableFee=" + payableFee + ", totalPrice="
				+ totalPrice + ", paymentWay=" + paymentWay + ", paymentCash="
				+ paymentCash + ", delivery=" + delivery + ", isConfirm="
				+ isConfirm + ", isPaiy=" + isPaiy + ", state=" + state
				+ ", createDate=" + createDate + ", note=" + note
				+ ", buyerId=" + buyerId + "]";
	}

}
