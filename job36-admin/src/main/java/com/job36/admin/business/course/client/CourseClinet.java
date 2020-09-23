package com.job36.admin.business.course.client;

import com.job36.common.entity.Pager;
import com.job36.domain.course.vo.CourseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @Description :
 * @Author : zhuzq
 * @Date: 2020/9/21 11:52
 */
@FeignClient("job36-service")
@RequestMapping("/service/course")
@Component
public interface CourseClinet {

    @RequestMapping("/list")
    public Pager getList(@RequestBody CourseVo course);



}
