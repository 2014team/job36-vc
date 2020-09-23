package com.job36.service.business.course.controller;

import com.job36.common.entity.Pager;
import com.job36.domain.course.vo.CourseVo;
import com.job36.service.business.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : zhuzq
 * @Date: 2020/9/21 9:53
 */

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @RequestMapping("/list")
    public Pager getList(@RequestBody CourseVo course){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("enyity",course);
        Pager pager = new Pager();
        Pager page = courseService.getPageList(pager,paramMap);
        return page;
    }

    @RequestMapping("/get")
    public String get(Pager pager){
        Pager page = courseService.getPageList(pager,null);
        return "11";
    }

}
