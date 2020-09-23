package com.job36.admin.business.course.service.impl;

import com.job36.admin.business.course.client.CourseClinet;
import com.job36.admin.business.course.service.ICourseService;
import com.job36.common.entity.Pager;
import com.job36.domain.course.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseClinet courseClinet;

    @Override
    public Pager getList( CourseVo course) {

        return courseClinet.getList(course);
    }
}
