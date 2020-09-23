package com.job36.domain.course.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.job36.domain.course.entity.Course;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseVo extends Course {


}
