package com.nibnait.babasport.core.query.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nibnait.babasport.core.query.BaseQuery;

/**
 * 购买者条件对象
 * @author lixu
 * @Date [2014-3-28 下午05:58:00]
 */
public class BuyerQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private String username;
	public String getUsername() {
		return username;
	}
	public BuyerQuery setUsername(String username) {
		this.username = username;
		return this;
	}
	private boolean usernameLike;
	public BuyerQuery setUsernameLike(boolean isLike) {
		this.usernameLike = isLike;
		return this;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public BuyerQuery setPassword(String password) {
		this.password = password;
		return this;
	}
	private boolean passwordLike;
	public BuyerQuery setPasswordLike(boolean isLike) {
		this.passwordLike = isLike;
		return this;
	}
	private String gender;
	public String getGender() {
		return gender;
	}
	public BuyerQuery setGender(String gender) {
		this.gender = gender;
		return this;
	}
	private boolean genderLike;
	public BuyerQuery setGenderLike(boolean isLike) {
		this.genderLike = isLike;
		return this;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public BuyerQuery setEmail(String email) {
		this.email = email;
		return this;
	}
	private boolean emailLike;
	public BuyerQuery setEmailLike(boolean isLike) {
		this.emailLike = isLike;
		return this;
	}
	private String realName;
	public String getRealName() {
		return realName;
	}
	public BuyerQuery setRealName(String realName) {
		this.realName = realName;
		return this;
	}
	private boolean realNameLike;
	public BuyerQuery setRealNameLike(boolean isLike) {
		this.realNameLike = isLike;
		return this;
	}
	private Date registerTime;
	public Date getRegisterTime() {
		return registerTime;
	}
	public BuyerQuery setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
		return this;
	}
	private Integer provinceId;
	public Integer getProvinceId() {
		return provinceId;
	}
	public BuyerQuery setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
		return this;
	}
	private Integer cityId;
	public Integer getCityId() {
		return cityId;
	}
	public BuyerQuery setCityId(Integer cityId) {
		this.cityId = cityId;
		return this;
	}
	private Integer townId;
	public Integer getTownId() {
		return townId;
	}
	public BuyerQuery setTownId(Integer townId) {
		this.townId = townId;
		return this;
	}
	private String addr;
	public String getAddr() {
		return addr;
	}
	public BuyerQuery setAddr(String addr) {
		this.addr = addr;
		return this;
	}
	private boolean addrLike;
	public BuyerQuery setAddrLike(boolean isLike) {
		this.addrLike = isLike;
		return this;
	}
	private Integer isDel;
	public Integer getIsDel() {
		return isDel;
	}
	public BuyerQuery setIsDel(Integer isDel) {
		this.isDel = isDel;
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
	 * 设置排序按属性：username
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyUsername(boolean isAsc) {
		orderFields.add(new OrderField("username", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：password
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyPassword(boolean isAsc) {
		orderFields.add(new OrderField("password", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：gender
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyGender(boolean isAsc) {
		orderFields.add(new OrderField("gender", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：email
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyEmail(boolean isAsc) {
		orderFields.add(new OrderField("email", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：real_name
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyRealName(boolean isAsc) {
		orderFields.add(new OrderField("real_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：register_time
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyRegisterTime(boolean isAsc) {
		orderFields.add(new OrderField("register_time", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：province_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyProvinceId(boolean isAsc) {
		orderFields.add(new OrderField("province_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：city_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyCityId(boolean isAsc) {
		orderFields.add(new OrderField("city_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：town_id
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyTownId(boolean isAsc) {
		orderFields.add(new OrderField("town_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：addr
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyAddr(boolean isAsc) {
		orderFields.add(new OrderField("addr", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public BuyerQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
