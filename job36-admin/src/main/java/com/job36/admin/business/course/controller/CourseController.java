package com.job36.admin.business.course.controller;

import com.job36.admin.business.course.client.CourseClinet;
import com.job36.admin.business.course.service.ICourseService;
import com.job36.common.entity.Pager;
import com.job36.domain.course.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 课程
 * @Author : zhuzq
 * @Date: 2020/9/19 11:03
 */

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;
    @Autowired
    CourseClinet courseClinet;

    @RequestMapping("/test")
    @ResponseBody
    public String test(Integer pageNum,Integer pageSize){
        /*PageHelper.startPage(pageNum, pageSize);
        List<Course> courseList = courseService.select(null);
        PageInfo pageInfo = new PageInfo(courseList);
        System.out.printf("111");
        return null;*/

        CourseVo course = new CourseVo();
        Pager paget = courseService.getList(course);

        return null;
    }

    @RequestMapping("/test/jsp")
    public String testJsp(Integer pageNum,Integer pageSize){
        System.out.printf("11111111");
        return "/course/test";
    }
}
