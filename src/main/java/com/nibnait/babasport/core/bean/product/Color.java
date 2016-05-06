package com.nibnait.babasport.core.bean.product;

import java.io.Serializable;

/**
 * 颜色
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */
public class Color implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer parentId;
	private String imgUrl;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String toString() {
		return "Color [id=" + id + ",name=" + name + ",parentId=" + parentId + ",imgUrl=" + imgUrl + "]";
	}
}
