package com.sun.finalwork.controller;

import com.sun.finalwork.bean.Msg;
import com.sun.finalwork.mapper.InstituteMapper;
import com.sun.finalwork.pojo.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class InstituteController {
    @Autowired
    private InstituteMapper instituteMapper;

    @ResponseBody
    @GetMapping("getInstitude")
    public Msg getAll(){
        List<Institute> institutes = instituteMapper.selAll();
        if(institutes !=null && !institutes.isEmpty()){
            return Msg.success().add("institutes",institutes);
        }
        return Msg.fail();
    }

    @ResponseBody
    @GetMapping("getDeptById")
    public Msg getDeptById(String id){
        System.out.println("ssssssssssssssssssssss"+id);
        List<Map<String, String>> maps = instituteMapper.selDeptById(id);
        if(maps != null&& !maps.isEmpty()){
            return Msg.success().add("dept",maps);
        }
        return Msg.fail();
    }
}
