package com.job36.admin.business.course.service;


import com.job36.common.entity.Pager;
import com.job36.domain.course.vo.CourseVo;

public interface ICourseService {

    public Pager getList( CourseVo course);
}
