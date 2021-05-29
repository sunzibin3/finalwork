package com.sun.finalwork.controller;

import com.sun.finalwork.bean.Msg;
import com.sun.finalwork.mapper.QuotaMapper;
import com.sun.finalwork.pojo.Quota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuotaController {
    @Autowired
    private QuotaMapper quotaMapper;

   /* confirmQuota*/

    @ResponseBody
    @GetMapping("getQuota")
    public Msg getQuota(String user){
        List<Quota> quotas =null;
        if(user.equals("stu")){
            quotas = quotaMapper.getStuQuota();
        }
        return Msg.success().add("quotas", quotas);
    }

    @ResponseBody
    @RequestMapping("delQta/{key}")
    public Msg delQuota(@PathVariable("key") String key){
        Integer integer = quotaMapper.delQuota(key);
        if(integer >0 && integer != null){
            return Msg.success();
        }
        return Msg.fail();
    }



    @RequestMapping("changeQuota")
    public String changeQuota(Quota quota){
        Integer flag = quotaMapper.saveChange(quota);
        if(flag !=null && flag>0){
            return "manager/QuotaMan";
        }
        return "fail";
    }

    @ResponseBody
    @RequestMapping("confirmQuota/{id}")
    public Msg confirmQuota(@PathVariable("id") String id){
        String[] split = id.split("-");
        List<Integer> data = new ArrayList<>();
        for(String string : split){
            quotaMapper.usedQuota(string);
        }
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping("delQuota/{id}")
    public Msg addCourse(@PathVariable("id") String id){
        String[] split = id.split("-");
        List<Integer> data = new ArrayList<>();
        for(String string : split){
            quotaMapper.delQuota(string);
        }
        return Msg.success();
    }

    @RequestMapping("addQuota")
    public String addQuota(Quota quota){
        Integer flag=null;
        if(!quota.getQuotaName().equals("")&&quota.getWeight() !=null){
            flag = quotaMapper.addQuota(quota);
        }
        if(flag !=null && flag>0){
            return "manager/QuotaMan";
        }
        return "fail";
    }
}
