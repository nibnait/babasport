package com.nibnait.babasport.core.query.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nibnait.babasport.core.query.BaseQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午05:58:00]
 */
public class SkuQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public SkuQuery setId(Integer id) {
		this.id = id;
		return this;
	}
	private Integer productId;
	public Integer getProductId() {
		return productId;
	}
	public SkuQuery setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}
	private Integer colorId;
	public Integer getColorId() {
		return colorId;
	}
	public SkuQuery setColorId(Integer colorId) {
		this.colorId = colorId;
		return this;
	}
	private String size;
	public String getSize() {
		return size;
	}
	public SkuQuery setSize(String size) {
		this.size = size;
		return this;
	}
	private boolean sizeLike;
	public SkuQuery setSizeLike(boolean isLike) {
		this.sizeLike = isLike;
		return this;
	}
	private Double deliveFee;
	public Double getDeliveFee() {
		return deliveFee;
	}
	public SkuQuery setDeliveFee(Double deliveFee) {
		this.deliveFee = deliveFee;
		return this;
	}
	private Double skuPrice;
	public Double getSkuPrice() {
		return skuPrice;
	}
	public SkuQuery setSkuPrice(Double skuPrice) {
		this.skuPrice = skuPrice;
		return this;
	}
	private Integer stockInventory;
	public Integer getStockInventory() {
		return stockInventory;
	}
	public SkuQuery setStockInventory(Integer stockInventory) {
		this.stockInventory = stockInventory;
		return this;
	}
	private Integer skuUpperLimit;
	public Integer getSkuUpperLimit() {
		return skuUpperLimit;
	}
	public SkuQuery setSkuUpperLimit(Integer skuUpperLimit) {
		this.skuUpperLimit = skuUpperLimit;
		return this;
	}
	private String location;
	public String getLocation() {
		return location;
	}
	public SkuQuery setLocation(String location) {
		this.location = location;
		return this;
	}
	private boolean locationLike;
	public SkuQuery setLocationLike(boolean isLike) {
		this.locationLike = isLike;
		return this;
	}
	private String skuImg;
	public String getSkuImg() {
		return skuImg;
	}
	public SkuQuery setSkuImg(String skuImg) {
		this.skuImg = skuImg;
		return this;
	}
	private boolean skuImgLike;
	public SkuQuery setSkuImgLike(boolean isLike) {
		this.skuImgLike = isLike;
		return this;
	}
	private Integer skuSort;
	public Integer getSkuSort() {
		return skuSort;
	}
	public SkuQuery setSkuSort(Integer skuSort) {
		this.skuSort = skuSort;
		return this;
	}
	private String skuName;
	public String getSkuName() {
		return skuName;
	}
	public SkuQuery setSkuName(String skuName) {
		this.skuName = skuName;
		return this;
	}
	private boolean skuNameLike;
	public SkuQuery setSkuNameLike(boolean isLike) {
		this.skuNameLike = isLike;
		return this;
	}
	private Double marketPrice;
	public Double getMarketPrice() {
		return marketPrice;
	}
	public SkuQuery setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
		return this;
	}
	private Date createTime;
	public Date getCreateTime() {
		return createTime;
	}
	public SkuQuery setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
	private Date updateTime;
	public Date getUpdateTime() {
		return updateTime;
	}
	public SkuQuery setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}
	private String createUserId;
	public String getCreateUserId() {
		return createUserId;
	}
	public SkuQuery setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
		return this;
	}
	private boolean createUserIdLike;
	public SkuQuery setCreateUserIdLike(boolean isLike) {
		this.createUserIdLike = isLike;
		return this;
	}
	private String updateUserId;
	public String getUpdateUserId() {
		return updateUserId;
	}
	public SkuQuery setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
		return this;
	}
	private boolean updateUserIdLike;
	public SkuQuery setUpdateUserIdLike(boolean isLike) {
		this.updateUserIdLike = isLike;
		return this;
	}
	private Integer lastStatus;
	public Integer getLastStatus() {
		return lastStatus;
	}
	public SkuQuery setLastStatus(Integer lastStatus) {
		this.lastStatus = lastStatus;
		return this;
	}
	private Integer skuType;
	public Integer getSkuType() {
		return skuType;
	}
	public SkuQuery setSkuType(Integer skuType) {
		this.skuType = skuType;
		return this;
	}
	private Integer sales;
	public Integer getSales() {
		return sales;
	}
	public SkuQuery setSales(Integer sales) {
		this.sales = sales;
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
	public SkuQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：product_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyProductId(boolean isAsc) {
		orderFields.add(new OrderField("product_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：color_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyColorId(boolean isAsc) {
		orderFields.add(new OrderField("color_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：size
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbySize(boolean isAsc) {
		orderFields.add(new OrderField("size", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：delive_fee
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyDeliveFee(boolean isAsc) {
		orderFields.add(new OrderField("delive_fee", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：sku_price
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbySkuPrice(boolean isAsc) {
		orderFields.add(new OrderField("sku_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：stock_inventory
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyStockInventory(boolean isAsc) {
		orderFields.add(new OrderField("stock_inventory", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：sku_upper_limit
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbySkuUpperLimit(boolean isAsc) {
		orderFields.add(new OrderField("sku_upper_limit", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：location
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyLocation(boolean isAsc) {
		orderFields.add(new OrderField("location", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：sku_img
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbySkuImg(boolean isAsc) {
		orderFields.add(new OrderField("sku_img", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：sku_sort
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbySkuSort(boolean isAsc) {
		orderFields.add(new OrderField("sku_sort", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：sku_name
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbySkuName(boolean isAsc) {
		orderFields.add(new OrderField("sku_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：market_price
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyMarketPrice(boolean isAsc) {
		orderFields.add(new OrderField("market_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：create_time
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyCreateTime(boolean isAsc) {
		orderFields.add(new OrderField("create_time", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：update_time
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyUpdateTime(boolean isAsc) {
		orderFields.add(new OrderField("update_time", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：create_user_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyCreateUserId(boolean isAsc) {
		orderFields.add(new OrderField("create_user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：update_user_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyUpdateUserId(boolean isAsc) {
		orderFields.add(new OrderField("update_user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：last_status
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbyLastStatus(boolean isAsc) {
		orderFields.add(new OrderField("last_status", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：sku_type
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbySkuType(boolean isAsc) {
		orderFields.add(new OrderField("sku_type", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：sales
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public SkuQuery orderbySales(boolean isAsc) {
		orderFields.add(new OrderField("sales", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
