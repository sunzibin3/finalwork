package com.sun.finalwork.service.impl;

import com.sun.finalwork.bean.EvaluateTeachers;
import com.sun.finalwork.bean.Quota;
import com.sun.finalwork.bean.StuChartMsg;
import com.sun.finalwork.bean.UserDate;
import com.sun.finalwork.bean.teacher.MsgDates;
import com.sun.finalwork.bean.teacher.TeaChangeMsg;
import com.sun.finalwork.bean.teacher.TeaEva;
import com.sun.finalwork.bean.teacher.TeaEvaData;
import com.sun.finalwork.mapper.TeacherMapper;
import com.sun.finalwork.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<StuChartMsg> selChartMsg(String teaRoomNo) {
        return teacherMapper.selTeacherAvg(teaRoomNo);
    }

    @Override
    public Integer getStuMsgNum(String tno) {
        return teacherMapper.selStuMsgNum(tno);
    }

    @Override
    public List<MsgDates> getStuMsg(String tno) {
        return teacherMapper.selStuMsg(tno);
    }

    @Override
    public Integer updStuMsgFlag(Integer id) {
        return teacherMapper.updStuMsgFlag(id);
    }

    @Override
    public String selTeaImg(String tno) {
        return teacherMapper.selTeaImgPath(tno);
    }

    @Override
    public Integer savePic(String userNo,String relPath) {
        return teacherMapper.insTeaPicByUserNo(userNo,relPath);
    }

    @Override
    public Integer saveTeaMsg(TeaChangeMsg teaChangeMsg) {
        return teacherMapper.saveTeaMsg(teaChangeMsg);
    }

    @Override
    public List<TeaEva> selTeachers(UserDate teaDate) {
        return teacherMapper.selTeachers(teaDate);
    }

    @Override
    public Integer selTeaEvaFlag(String userNo, String tno) {
        return teacherMapper.selTeaEvaFlag(userNo,tno);
    }

    @Override
    public List<Quota> selQuotaItems() {
        return teacherMapper.selQuotaItems();
    }

    @Override
    public Integer saveTeaEva(List<TeaEvaData> data) {
        return teacherMapper.saveTeaEva(data);
    }

    @Override
    public List<Quota> getTeaEvaDatas(String userNo, String tid) {
        return teacherMapper.getTeaEvaDatas(userNo,tid);
    }
}
