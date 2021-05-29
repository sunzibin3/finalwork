package com.sun.finalwork.controller;

import com.sun.finalwork.bean.Msg;
import com.sun.finalwork.mapper.ClassInfoMapper;
import com.sun.finalwork.pojo.ClassInfo;
import com.sun.finalwork.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClassInfoController {
    @Autowired
    private ClassInfoService classInfoServiceImpl;

    @Autowired
    private ClassInfoMapper classInfoMapper;
    @ResponseBody
    @GetMapping("getClass")
    public Msg getClassList(){
        List<ClassInfo> classLIst = classInfoServiceImpl.getAll();
        return Msg.success().add("classList",classLIst);
    }

    @ResponseBody
    @GetMapping("getclassById")
    public Msg getClassById(String id){
        List<ClassInfo> classes = classInfoMapper.getAllByDepId(id);
        if(classes !=null && !classes.isEmpty()){
            return Msg.success().add("classList",classes);
        }
        return Msg.fail();
    }


}
