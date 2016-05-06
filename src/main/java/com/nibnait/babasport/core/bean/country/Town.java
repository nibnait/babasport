package com.nibnait.babasport.core.bean.country;

import java.io.Serializable;

/**
 * 县/区
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class Town implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code;
	private String name;
	private String city;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String toString() {
		return "Town [id=" + id + ",code=" + code + ",name=" + name + ",city=" + city + "]";
	}
}
