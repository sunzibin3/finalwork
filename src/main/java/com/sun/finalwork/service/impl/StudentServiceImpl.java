package com.sun.finalwork.service.impl;
import com.sun.finalwork.bean.*;
import com.sun.finalwork.mapper.StudentMapper;
import com.sun.finalwork.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Student getStuMsgById(String id) {
        return studentMapper.selStudentById(id);
    }

    @Override
    public int updStuById(Student student) {
        return studentMapper.updStuById(student);
    }

    @Override
    public List<stuCourse> selStuCourseByIdCid(String id, int courseId,String batch) {
        return studentMapper.selStuCourseByIdCid(id,courseId,batch);
    }

    @Override
    public List<ChooseCourse> selCourseById(String id,int classId) {
        return studentMapper.selCourseById(id,classId);
    }

    @Override
    public Map<String, String> selNameBatchId(String sd) {
        return studentMapper.selNameBatchId(sd);
    }

    @Override
    public int addStuCourse(List<AddCourse> data) {
        return studentMapper.insStuCourse(data);
    }

    @Override
    public List<EvaluateTeachers> selTeachers(String sno, String classId) {
        return studentMapper.selTeachersByIdClassId(sno,classId);
    }

    @Override
    public List<Quota> selQuota() {
        return studentMapper.selQuota();
    }

    @Override
    public Integer getEvaFlagMsg(String username,String tid) {
        return studentMapper.selEvaFlagMsg(username,tid);
    }

    @Override
    public Integer updStuMsgToTea(StuMsgToTea stuMsgToTea) {
        return studentMapper.insStuMsgToTea(stuMsgToTea);
    }

    @Override
    public Integer changStuEvaFlag(String sno, String tno) {
        return studentMapper.changStuEvaFlag(sno,tno);
    }

    @Override
    public Integer addStuEva(List<StuEva> data) {
        return studentMapper.insStuEva(data);
    }

    @Override
    public List<StuChartMsg> selStuChartMsg(String id) {
        return studentMapper.selTeacherAvg(id);
    }

    @Override
    public List<Quota> getStuEvaByTid(String sno, String tid) {
        return studentMapper.selStuEvaByTid(sno,tid);
    }
}

