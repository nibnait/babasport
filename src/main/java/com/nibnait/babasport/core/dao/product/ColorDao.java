package com.nibnait.babasport.core.dao.product;

import java.util.List;

import com.nibnait.babasport.core.bean.product.Color;
import com.nibnait.babasport.core.query.product.ColorQuery;

public interface ColorDao {

	/**
	 * 添加
	 * @param color
	 */
	public Integer addColor(Color color);

	/**
	 * 根据主键查找
	 * @param colorQuery
	 */
	public Color getColorByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param colorQuery
	 */
	public List<Color> getColorsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param colorQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param colorQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param colorQuery
	 */
	public Integer updateColorByKey(Color color);

	/**
	 * 分页查询
	 * @param colorQuery
	 */
	public List<Color> getColorListWithPage(ColorQuery colorQuery);

	/**
	 * 集合查询
	 * @param colorQuery
	 */
	public List<Color> getColorList(ColorQuery colorQuery);
	
	/**
	 * 总条数
	 * @param colorQuery
	 */
	public int getColorListCount(ColorQuery colorQuery);
}
