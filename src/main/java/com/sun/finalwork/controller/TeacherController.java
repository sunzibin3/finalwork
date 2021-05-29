package com.sun.finalwork.controller;

import com.sun.finalwork.bean.*;
import com.sun.finalwork.bean.teacher.MsgDates;
import com.sun.finalwork.bean.teacher.TeaChangeMsg;
import com.sun.finalwork.bean.teacher.TeaEva;
import com.sun.finalwork.bean.teacher.TeaEvaData;
import com.sun.finalwork.mapper.TeacherMapper;
import com.sun.finalwork.service.StudentService;
import com.sun.finalwork.service.TeacherService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class TeacherController {
    @Autowired
    private StudentService studentServiceImpl;

    @Autowired
    private TeacherService teacherServiceImpl;

    @Autowired
    private TeacherMapper teacherMapper;


    @ResponseBody
    @RequestMapping("getStuEvaBySno")
    public Msg getStuEvaBySno(HttpSession session,String sno){
        UserDate teaDate =(UserDate) session.getAttribute("teaDate");
        List<Quota> quotas = studentServiceImpl.getStuEvaByTid(sno,teaDate.getUserNo());
        return Msg.success().add("quotas",quotas);
    }

    @RequestMapping("/tea/getStuLIst")
    public String getStuLIst(Model model,HttpSession session){
        UserDate teaDate =(UserDate) session.getAttribute("teaDate");
        List<Map<String, String>> allStu = teacherMapper.getAllStu(teaDate.getUserNo());
        if(!allStu.isEmpty()){
            model.addAttribute("flag",1);
            model.addAttribute("stuList",allStu);
        }else {
            model.addAttribute("flag",0);
        }
        return "teacher/showStuEva";
    }

    @ResponseBody
    @GetMapping("/getEvaItemByTno")
    public Msg getEvaItemByTno(String tno){
        List<Map<String, String>> all = teacherMapper.getAll(tno);
        if(!all.isEmpty()){
            return Msg.success().add("eav_item",all);
        }
        return Msg.fail();
    }

    //获取主页图表信心
    @ResponseBody
    @RequestMapping("teaChartMsg")
    public Msg getChartMsg(HttpSession session){
        UserDate userDate =(UserDate) session.getAttribute("teaDate");
        String teaRoomNo = userDate.getTeacherRoomNo();
        List<StuChartMsg> chartMsgs= teacherServiceImpl.selChartMsg(teaRoomNo);
        /*for(StuChartMsg stuChartMsg:chartMsgs){
            System.out.println(stuChartMsg);
        }*/
        return Msg.success().add("charDates",chartMsgs);
    }

    //获取未读信息个数
    @ResponseBody
    @RequestMapping("/getStuMsgNum")
    public Integer getMsgNum(HttpSession session){
        UserDate userDate = (UserDate) session.getAttribute("teaDate");
        return teacherServiceImpl.getStuMsgNum(userDate.getUserNo());
    }

    //获取学生留言
    @ResponseBody
    @RequestMapping("/getStuMsg")
    public Msg getStuMsgList(HttpSession session){
        UserDate userDate = (UserDate) session.getAttribute("teaDate");
        List<MsgDates> result = teacherServiceImpl.getStuMsg(userDate.getUserNo());
        if(result != null && !result.isEmpty()){
            return Msg.success().add("result",result);
        }else {
            return Msg.fail();
        }
    }
    //修改留言表状态
    @ResponseBody
    @RequestMapping("/updStuMsgFlag")
    public Msg updStuMsgFlag(Integer id,Integer flag){
        if(flag==1){
            Integer ss = teacherServiceImpl.updStuMsgFlag(id);
            if(null !=ss && ss>0){
                return Msg.success();
            }else {
                return Msg.fail();
            }
        }else{
            return Msg.success();
        }
    }
    /**
     * 获取教师头像
     * @param tno 教师号
     * @return 教师头像存储路径
     */
    @ResponseBody
    @RequestMapping("/showTeaImg")
    public Msg getTeaImg(String tno){
        String teaImgPath = teacherServiceImpl.selTeaImg(tno);
        if(null != teaImgPath){
            return Msg.success().add("path",teaImgPath);
        }else{
            return Msg.fail();
        }
    }

    /**
     * 教师信息保存控制器
     * @param teaChangeMsg 数据类pojo
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/changeTeaDate")
    //@RequestParam("fileName") MultipartFile file,String password,String userName,Integer sex
    public Msg changTeaDate(TeaChangeMsg teaChangeMsg,HttpSession session){
        MultipartFile file = teaChangeMsg.getFileName();
        UserDate teaDate = (UserDate) session.getAttribute("teaDate");
        if(file.isEmpty()){
            Integer msgFlag = teacherServiceImpl.saveTeaMsg(teaChangeMsg);
            if(null !=msgFlag && msgFlag>0){
                teaDate.setPassword(teaChangeMsg.getPassword());
                teaDate.setUserName(teaChangeMsg.getUserName());
                teaDate.setSex(teaChangeMsg.getSex().toString());
                session.setAttribute("teaDate",teaDate);
                return Msg.success();
            }else {
                return Msg.fail().add("note","保存失败，请重试");
            }
        }else{
            String suffix = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String path = "E:/javaPro/finalwork/src/main/resources/static/img/";
            suffix=suffix.substring(suffix.lastIndexOf('.'));
            if(suffix.equals(".jpg") || suffix.equals(".png")){
                String relPath=path+uuid+suffix;
                Integer picflag = teacherServiceImpl.savePic(teaChangeMsg.getUserNo(),uuid+suffix);
                if(null != picflag && picflag>0){
                    Integer msgFlag = teacherServiceImpl.saveTeaMsg(teaChangeMsg);
                    if(null !=msgFlag && msgFlag>0){
                        teaDate.setPassword(teaChangeMsg.getPassword());
                        teaDate.setUserName(teaChangeMsg.getUserName());
                        teaDate.setSex(teaChangeMsg.getSex().toString());
                        session.setAttribute("teaDate",teaDate);
                        try {
                            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(relPath));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }else{
                    return Msg.fail().add("note","保存失败，请重试");
                }

            }else{
                return Msg.fail().add("note","文件格式错误");
            }
        }
        return Msg.success();
    }


    /**
     * 查询同一教研室的教师名单
     * @param session
     * @param model
     * @return 教师List
     */
    @RequestMapping("/tea/getTeacherList")
    public String getTeacherList(HttpSession session, Model model){
        UserDate teaDate=(UserDate) session.getAttribute("teaDate");
        List<TeaEva> teachers = teacherServiceImpl.selTeachers(teaDate);
        /*for (TeaEva t:
             teachers) {
            System.out.println(t);
        }*/
        if(!teachers.isEmpty()){
            model.addAttribute("teachers",teachers);
            return "teacher/EvaluateTeacherLIst";
        }
        return "fail";
    }

    @RequestMapping("/getTeaevalist/{tno}")
    public String getTeaEvaList(@PathVariable("tno") String tno,HttpSession session,Model model){
        UserDate userDate = (UserDate) session.getAttribute("teaDate");
        Integer flag = teacherServiceImpl.selTeaEvaFlag(userDate.getUserNo(),tno);
        if(flag == null || flag ==0){
            List<Quota> quotas = teacherServiceImpl.selQuotaItems();
            model.addAttribute("evaTid",tno);
            model.addAttribute("quotas",quotas);
            return "teacher/quotaList.html";
        }
        return "fail";
    }


    /**
     * 将评价信息持久化
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping("/addTeaEva")
    public Msg addTeaEva(@RequestBody List<TeaEvaData> data){
        /*System.out.println(data.get(0).getTno()+","+data.get(0).getEavtno());
        for (TeaEvaData stuEva:data){
            System.out.println(stuEva);
        }*/
        if(!data.isEmpty()){
            Integer flag = teacherServiceImpl.saveTeaEva(data);
            if(flag>0 && flag !=null){
                return Msg.success();
            }
        }
        return Msg.fail();
    }

    @ResponseBody
    @RequestMapping("getTeaEvaByTid")
    public Msg getTeaEvaByTid(String tid,HttpSession session){
        UserDate userda = (UserDate) session.getAttribute("teaDate");
        List<Quota> quotas = teacherServiceImpl.getTeaEvaDatas(userda.getUserNo(),tid);
        return Msg.success().add("quotas",quotas);
    }

}
