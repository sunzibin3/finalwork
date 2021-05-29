package com.sun.finalwork.controller;

import com.sun.finalwork.mapper.TeachingMapper;
import com.sun.finalwork.pojo.Teaching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeachingController {

    @Autowired
    private TeachingMapper teachingMapper;
    @RequestMapping("addTeaching")
    public String addTeaching(Teaching teaching){
        Integer integer = teachingMapper.insTeaching(teaching);
        if(null!=integer&&integer>0){
            return "redirect:/classManager";
        }
        return "fail";
    }

}
