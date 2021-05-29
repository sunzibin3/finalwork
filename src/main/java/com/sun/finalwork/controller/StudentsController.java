package com.sun.finalwork.controller;

import com.sun.finalwork.bean.*;
import com.sun.finalwork.service.StudentService;
import com.sun.finalwork.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentsController {
    @Autowired
    private StudentService studentServiceImpl;

    @RequestMapping("/getStuMsg/{id}")
    public String showStuMsg(@PathVariable("id") String id, Model model){
        model.addAttribute("stus",studentServiceImpl.getStuMsgById(id));
        return "student/stuMsg";
    }

    @ResponseBody
    @RequestMapping("/getStuCourse/{id}/{courseId}")
    public Msg getStuCourse(@PathVariable("id") String id, @PathVariable("courseId") int courseId, String batch){
        if(!studentServiceImpl.selStuCourseByIdCid(id,courseId,batch).isEmpty()){
            List<stuCourse>courses = studentServiceImpl.selStuCourseByIdCid(id,courseId,batch);
            return Msg.success().add("result",courses);
        }else{
            return Msg.fail();
        }
    }

    @PostMapping("/stuUpd")
    public String updStuById(Student student,HttpSession session){
        String id = (String) session.getAttribute("username");
        if(studentServiceImpl.updStuById(student)>0 ){
            System.out.println(studentServiceImpl.updStuById(student));
            return "redirect:/getStuMsg/"+id;
        }else{
            return "fail";
        }
    }

    @RequestMapping("/chooseCourse/{id}")
    public String chooseCourse(@PathVariable("id") String id,Model model,HttpSession session){
        int classId = (Integer) session.getAttribute("userClassNo");
        List<ChooseCourse> courses = studentServiceImpl.selCourseById(id,classId);
        if(!courses.isEmpty()){
            model.addAttribute("courses",courses);
        }else{
            model.addAttribute("courses",0);
        }
        return "student/chooseCourse";
    }

    @ResponseBody
    @RequestMapping("/addCourse/{id}")
    public Msg addCourse(@PathVariable("id") String courseId, HttpSession session){
        String sd= (String) session.getAttribute("username");
        Map<String,String> result = studentServiceImpl.selNameBatchId(sd);
        String[] split = courseId.split("-");
        List<AddCourse> data = new ArrayList<>();
        for(String string : split){
            data.add(new AddCourse(sd,Integer.parseInt(string),result.get("userName"),result.get("batchId"),1));
        }
        int ss =studentServiceImpl.addStuCourse(data);
        return Msg.success();
    }
    @ResponseBody
    @RequestMapping("test")
    public String test(HttpSession session){
//        String sd= (String) session.getAttribute("username");
//        Map<String,String> result = studentServiceImpl.selNameBatchId(sd);
        return "sadas";
    }

    @RequestMapping("getTeacherList")
    public String getTeacherList(HttpSession session,Model model){
        String sno=(String) session.getAttribute("username");
        String userClassNo=session.getAttribute("userClassNo").toString();
        List<EvaluateTeachers> teachers = studentServiceImpl.selTeachers(sno, userClassNo);
        if(!teachers.isEmpty()){
            model.addAttribute("teachers",teachers);
            return "student/EvaluateTeacherLIst";
        }
        return "student/stufail";
    }

    @RequestMapping("getTeachersBysnoClassNo")
    public String getTeachersBysnoClassNo(String sno,String classNo,Model model,String name){
        List<EvaluateTeachers> teachers = studentServiceImpl.selTeachers(sno, classNo);
        if(!teachers.isEmpty()){
            model.addAttribute("teachers",teachers);
            model.addAttribute("sno", sno);
            model.addAttribute("name", name);
            return "manager/EvaluateTeacherLIst";
        }
        return "student/stufail";
    }


    @RequestMapping("/getevalist/{tid}")
    public String getEvaList(@PathVariable("tid") String tid,Model model,HttpSession session){
        Integer flag = studentServiceImpl.getEvaFlagMsg((String)session.getAttribute("username"),tid);
        if(flag == null){
            model.addAttribute("tid",tid);
            List<Quota> quotaList = studentServiceImpl.selQuota();
            model.addAttribute("quotas",quotaList);
            return "student/quotaList";
        }
        return "student/EvaluateTeacherLIst";
    }

    //添加学生留言
    @ResponseBody
    @RequestMapping("/saveStuMSg")
    public Msg saveStuMSg(StuMsgToTea stuMsgToTea){
        System.out.println(stuMsgToTea);
        if(studentServiceImpl.updStuMsgToTea(stuMsgToTea)>0){
            return Msg.success();
        }
        return Msg.fail();
    }
    //添加学生评价信息
    @ResponseBody
    @RequestMapping("/addStuEva")
    public Msg addStuEva(@RequestBody List<StuEva> data){
        Integer i = studentServiceImpl.changStuEvaFlag(data.get(0).getSno(),data.get(0).getTno());
        if(i!=null && i>0){
            Integer flag=studentServiceImpl.addStuEva(data);
            if(null != flag && flag>0){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }else{
            return Msg.fail();
        }
        /*System.out.println(data.get(0).getSno()+","+data.get(0).getTno());
        for (StuEva stuEva:data){
            System.out.println(stuEva);
        }*/
    }
    //查询任课教师分数信息
    @ResponseBody
    @RequestMapping("chartMsg")
    public Msg getChartMsg(HttpSession session){
        String id =(String) session.getAttribute("username");
        List<StuChartMsg>stuChartMsgs= studentServiceImpl.selStuChartMsg(id);
        for(StuChartMsg stuChartMsg:stuChartMsgs){
            System.out.println(stuChartMsg);
        }
        Map<String,Object>ss = new HashMap<>();
        ss.put("ss",stuChartMsgs);
        return Msg.success().add("ss",stuChartMsgs);
        //return Msg.success().setExtend(ss);
    }

    //查询学生对指定教师的评价信息
    @ResponseBody
    @RequestMapping("getStuEvaByTid")
    public Msg getStuEvaByTid(String tid,HttpSession session){
        List<Quota> quotas = studentServiceImpl.getStuEvaByTid((String) session.getAttribute("username"),tid);
        return Msg.success().add("quotas",quotas);
    }

    @ResponseBody
    @RequestMapping("getStuEvaByTidSno")
    public Msg getStuEvaByTid(String tid,String sno){
        List<Quota> quotas = studentServiceImpl.getStuEvaByTid(sno,tid);
        return Msg.success().add("quotas",quotas);
    }

}
