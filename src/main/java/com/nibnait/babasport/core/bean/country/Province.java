package com.nibnait.babasport.core.bean.country;

import java.io.Serializable;

/**
 * 省
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class Province implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String code;
	private String name;

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
	public String toString() {
		return "Province [id=" + id + ",code=" + code + ",name=" + name + "]";
	}
}
