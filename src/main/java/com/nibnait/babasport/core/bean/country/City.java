package com.nibnait.babasport.core.bean.country;

import java.io.Serializable;

/**
 * 市
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class City implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code;
	private String name;
	private String province;

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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String toString() {
		return "City [id=" + id + ",code=" + code + ",name=" + name + ",province=" + province + "]";
	}
}
