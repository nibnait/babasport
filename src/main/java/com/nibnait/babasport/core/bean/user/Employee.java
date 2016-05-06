package com.nibnait.babasport.core.bean.user;

import java.io.Serializable;

/**
 * 员工
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class Employee implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String degree;
	private String email;
	private Integer gender;
	private String imgUrl;
	private String phone;
	private String realName;
	private String school;
	private Integer isDel;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public String toString() {
		return "Employee [username=" + username + ",password=" + password + ",degree=" + degree + ",email=" + email + ",gender=" + gender + ",imgUrl=" + imgUrl + ",phone=" + phone + ",realName=" + realName + ",school=" + school + ",isDel=" + isDel + "]";
	}
}
