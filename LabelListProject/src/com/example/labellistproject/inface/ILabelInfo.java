package com.example.labellistproject.inface;

public interface ILabelInfo<T> {

	/**
	 * 标签内容
	 * 
	 * @param object
	 * @return
	 */
	public String getLabelName(T object);

	/**
	 * 标签字体颜色
	 * 
	 * @param object
	 * @return
	 */
	public String getTextColor(T object);

	/**
	 * 标签背景颜色
	 * 
	 * @param object
	 * @return
	 */
	public String getBackgroundColor(T object);

	/**
	 * 标签外框颜色
	 * 
	 * @param object
	 * @return
	 */
	public String getStrokeColor(T object);

}
