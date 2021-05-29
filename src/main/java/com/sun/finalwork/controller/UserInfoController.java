package com.sun.finalwork.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.finalwork.bean.Msg;
import com.sun.finalwork.mapper.UserInfoMapper;
import com.sun.finalwork.pojo.UserInfo;
import com.sun.finalwork.service.UserInfoService;
import com.sun.finalwork.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 对用户表进行操作
 */
@Controller
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoServiceImpl;

    @Autowired
    private UserInfoMapper userInfoMapper;



    @ResponseBody
    @RequestMapping("getStuByClass")
    public Msg getStuByClass(String key){
        List<Map<String, String>> stu = userInfoMapper.getStuToMapByClass(key);
        return Msg.success().add("stus", stu);
    }

    /**
     * 模糊查询
     * @param msg
     * @return
     *//*
    @ResponseBody
    @GetMapping("getUserByMsg")
    public Msg getUserByMsg(String msg,String userType){
        msg = msg+"%";
        List<UserInfo> user = userInfoServiceImpl.getUserByMsg(msg,userType);
        if(user.isEmpty()){
            System.out.println("sadas");
            return Msg.fail();
        }else{
            return Msg.success().add("user",user);
        }
    }*/

    /**
     * 模糊查询
     * @param msg
     * @return
     */
    @ResponseBody
    @GetMapping("getUserByMsg")
    public Msg getUserByMsg(String msg,String userType){
        msg = msg+"%";
        List<Map<String, String>> teaToMap = userInfoServiceImpl.getTeaToMap(msg, userType);
        if(teaToMap.isEmpty()){
            System.out.println("sadas");
            return Msg.fail();
        }else{
            return Msg.success().add("user",teaToMap);
        }
    }





    /**
     * 查询用户列表
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("getStu")
    public Msg getAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,10);
        List<UserInfo> stu = userInfoServiceImpl.getAllStu();
        PageInfo pageInfo = new PageInfo(stu,10);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @ResponseBody
    @RequestMapping("getTeassss")
    public Msg test(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,10);
        List<Map<String,String>> stu = userInfoServiceImpl.getTeaToMap();
        PageInfo pageInfo = new PageInfo(stu,10);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @ResponseBody
    @RequestMapping("getTea")
    public Msg getTea(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,10);
        List<UserInfo> stu = userInfoServiceImpl.getAllTea();
        PageInfo pageInfo = new PageInfo(stu,10);
        return Msg.success().add("pageInfo",pageInfo);
    }


    @ResponseBody
    @RequestMapping("getAllTea")
    public Msg getTea(){
        List<UserInfo> teas = userInfoServiceImpl.getAllTea();
        if(!teas.isEmpty()){
            return Msg.success().add("teas",teas);
        }
        return Msg.fail();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("delStu")
    public Msg delStu(String id){
        Integer flag = userInfoServiceImpl.delUser(id);
        if(null != flag && flag>0){
            return Msg.success();
        }
        return Msg.fail();
    }
    /**
     * 更新用户
     */
    @PostMapping("userUpd/{user}")
    public String userUpdById(@PathVariable("user") String user,UserInfo userInfo){
        System.out.println(userInfo);
        Integer i = userInfoServiceImpl.updUser(userInfo);
        if(i != null && i>0 && user.equals("stu")){
            return "redirect:/studata";
        }else if (user.equals("tea")){
            return "redirect:/teadata";
        }else{
            return "/fail";
        }
    }

    /**
     * 添加用户
     * @param user
     * @param userInfo
     * @return
     */
    @PostMapping("/addUser/{stu}")
    public String addUser(@PathVariable("stu") String user,UserInfo userInfo){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        userInfo.setStarttime(formatter.format(new Date()));
        if(user.equals("stu")){
            userInfo.setPosition("stu");userInfo.setUsertype(1);
            Integer i =userInfoServiceImpl.addUser(userInfo);
            if(i!=null && i>0){
                return "redirect:/studata";
            }
        }else if(user.equals("tea")){
            userInfo.setPosition("tea");userInfo.setUsertype(1);
            Integer i =userInfoServiceImpl.addUser(userInfo);
            if(i!=null && i>0){
                return "redirect:/teadata";
            }
        }
        return "/fail";
    }
}
