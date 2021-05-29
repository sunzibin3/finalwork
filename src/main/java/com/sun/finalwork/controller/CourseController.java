package com.sun.finalwork.controller;

import com.sun.finalwork.bean.Msg;
import com.sun.finalwork.mapper.CourseMapper;
import com.sun.finalwork.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseMapper courseMapper;

    @ResponseBody
    @GetMapping("findCourse")
    public Msg findCourse(Integer insId,String classId){
        List<Course> courseList = courseMapper.selCourseByInsId(insId,classId);
        if(!courseList.isEmpty() && courseList != null){
            return Msg.success().add("courseList",courseList);
        }
        return Msg.fail();
    }
}
