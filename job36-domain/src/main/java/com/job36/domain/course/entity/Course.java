package com.job36.domain.course.entity;

import com.job36.domain.base.BaseEntity;

public class Course extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 课程专栏名称
	 */
	private String courseName;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}