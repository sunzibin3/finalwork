package com.sun.finalwork.service;

import com.sun.finalwork.bean.*;

import java.util.List;
import java.util.Map;

public interface StudentService {
    //查询学生信息
    Student getStuMsgById(String id);
    //更新信息
    int updStuById(Student student);
    //根据学号和班级和查询课程
    List<stuCourse> selStuCourseByIdCid(String id, int courseId,String batch);

    List<ChooseCourse> selCourseById(String id,int classId);

    Map<String, String> selNameBatchId(String sd);

    int addStuCourse(List<AddCourse> data);

    List<EvaluateTeachers> selTeachers(String sno,String classId);

    List<Quota> selQuota();

    Integer getEvaFlagMsg(String username,String tid);

    Integer updStuMsgToTea(StuMsgToTea stuMsgToTea);

    Integer changStuEvaFlag(String sno, String tno);
    //添加学生评价
    Integer addStuEva(List<StuEva> data);
    //查找学生页面图标显示信息
    List<StuChartMsg> selStuChartMsg(String id);

    List<Quota> getStuEvaByTid(String sno,String tid);
}
