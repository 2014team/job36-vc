package com.job36.api.business.course.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 课程
 * @Author : zhuzq
 * @Date: 2020/9/19 11:03
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @RequestMapping("/test")
    public String test(){
        return "job36-api";
    }
}
