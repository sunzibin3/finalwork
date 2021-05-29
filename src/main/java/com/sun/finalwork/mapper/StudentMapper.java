package com.sun.finalwork.mapper;

import com.sun.finalwork.bean.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Select("select * from student where username=#{username}and password=#{password}")
    Integer selStudent(Student student);

    @Select("select userNo,password,userName,sex,position,classNo,classinfo.className from userinfo,classinfo where userinfo.classNo=classinfo.Id AND userNo = #{id}")
    Student selStudentById(String id);

    @Update("update userinfo set password = #{password},userName=#{userName},sex=#{sex} where userNo=#{userNo} and position='stu'")
    int updStuById(Student student);

    List<stuCourse> selStuCourseByIdCid(@Param("sno") String sno, @Param("courseId") int courseId,@Param("batch") String batch);

    List<ChooseCourse> selCourseById(@Param("id") String id,@Param("classId") int classId);

    @Select("SELECT userName,batchId from userinfo where userNo= #{sd}")
    Map<String, String> selNameBatchId(String sd);

    int insStuCourse(List<AddCourse> list);

    List<EvaluateTeachers> selTeachersByIdClassId(@Param("sno") String sno,@Param("classId") String classId);

    @Select("select * from quota where isUsed=1")
    List<Quota> selQuota();

    @Select("select * from stuevaluate where sno=#{username} and tno=#{tid}")
    Integer selEvaFlagMsg(@Param("username") String username,@Param("tid") String tid);

    @Insert("insert into stumsgtotea values(default,#{stuMsgToTea.sno},#{stuMsgToTea.tno},#{stuMsgToTea.msg},default,default)")
    Integer insStuMsgToTea(@Param("stuMsgToTea") StuMsgToTea stuMsgToTea);

    Integer changStuEvaFlag(@Param("sno") String sno,@Param("tno") String tno);

    Integer insStuEva(@Param("datas") List<StuEva> data);


    //查询图表显示所需数据
    List<StuChartMsg> selTeacherAvg(@Param("id") String id);
    //按照学生名和教师编号查询学生对指定教师评价信息
    List<Quota> selStuEvaByTid(@Param("sno") String sno,@Param("tid") String tid);
}

