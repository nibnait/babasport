package com.nibnait.babasport.core.query.user;

import java.util.ArrayList;
import java.util.List;

import com.nibnait.babasport.core.query.BaseQuery;

/**
 * 员工条件对象
 * @author lixu
 * @Date [2014-3-28 下午05:58:00]
 */
public class EmployeeQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private String username;
	public String getUsername() {
		return username;
	}
	public EmployeeQuery setUsername(String username) {
		this.username = username;
		return this;
	}
	private boolean usernameLike;
	public EmployeeQuery setUsernameLike(boolean isLike) {
		this.usernameLike = isLike;
		return this;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public EmployeeQuery setPassword(String password) {
		this.password = password;
		return this;
	}
	private boolean passwordLike;
	public EmployeeQuery setPasswordLike(boolean isLike) {
		this.passwordLike = isLike;
		return this;
	}
	private String degree;
	public String getDegree() {
		return degree;
	}
	public EmployeeQuery setDegree(String degree) {
		this.degree = degree;
		return this;
	}
	private boolean degreeLike;
	public EmployeeQuery setDegreeLike(boolean isLike) {
		this.degreeLike = isLike;
		return this;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public EmployeeQuery setEmail(String email) {
		this.email = email;
		return this;
	}
	private boolean emailLike;
	public EmployeeQuery setEmailLike(boolean isLike) {
		this.emailLike = isLike;
		return this;
	}
	private Integer gender;
	public Integer getGender() {
		return gender;
	}
	public EmployeeQuery setGender(Integer gender) {
		this.gender = gender;
		return this;
	}
	private String imgUrl;
	public String getImgUrl() {
		return imgUrl;
	}
	public EmployeeQuery setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}
	private boolean imgUrlLike;
	public EmployeeQuery setImgUrlLike(boolean isLike) {
		this.imgUrlLike = isLike;
		return this;
	}
	private String phone;
	public String getPhone() {
		return phone;
	}
	public EmployeeQuery setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	private boolean phoneLike;
	public EmployeeQuery setPhoneLike(boolean isLike) {
		this.phoneLike = isLike;
		return this;
	}
	private String realName;
	public String getRealName() {
		return realName;
	}
	public EmployeeQuery setRealName(String realName) {
		this.realName = realName;
		return this;
	}
	private boolean realNameLike;
	public EmployeeQuery setRealNameLike(boolean isLike) {
		this.realNameLike = isLike;
		return this;
	}
	private String school;
	public String getSchool() {
		return school;
	}
	public EmployeeQuery setSchool(String school) {
		this.school = school;
		return this;
	}
	private boolean schoolLike;
	public EmployeeQuery setSchoolLike(boolean isLike) {
		this.schoolLike = isLike;
		return this;
	}
	private Integer isDel;
	public Integer getIsDel() {
		return isDel;
	}
	public EmployeeQuery setIsDel(Integer isDel) {
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
	public EmployeeQuery orderbyUsername(boolean isAsc) {
		orderFields.add(new OrderField("username", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：password
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbyPassword(boolean isAsc) {
		orderFields.add(new OrderField("password", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：degree
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbyDegree(boolean isAsc) {
		orderFields.add(new OrderField("degree", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：email
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbyEmail(boolean isAsc) {
		orderFields.add(new OrderField("email", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：gender
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbyGender(boolean isAsc) {
		orderFields.add(new OrderField("gender", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：img_url
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbyImgUrl(boolean isAsc) {
		orderFields.add(new OrderField("img_url", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：phone
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbyPhone(boolean isAsc) {
		orderFields.add(new OrderField("phone", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：real_name
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbyRealName(boolean isAsc) {
		orderFields.add(new OrderField("real_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：school
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbySchool(boolean isAsc) {
		orderFields.add(new OrderField("school", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，否则为降序
	 */
	public EmployeeQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
