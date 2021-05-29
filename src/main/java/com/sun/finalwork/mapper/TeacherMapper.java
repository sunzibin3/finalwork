package com.sun.finalwork.mapper;

import com.sun.finalwork.bean.*;
import com.sun.finalwork.bean.teacher.MsgDates;
import com.sun.finalwork.bean.teacher.TeaChangeMsg;
import com.sun.finalwork.bean.teacher.TeaEva;
import com.sun.finalwork.bean.teacher.TeaEvaData;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {
    //查询图表显示所需数据
    List<StuChartMsg> selTeacherAvg(@Param("tno") String tno);
    //查询未读信息
    @Select("select COUNT(*) from stumsgtotea where tno = #{tno} and flag = 1")
    Integer selStuMsgNum(String tno);
    //查询学生留言
    List<MsgDates> selStuMsg(@Param("tno") String tno);
    @Select("update stumsgtotea set flag=0 where id=#{id}")
    Integer updStuMsgFlag(Integer id);
    //获取教师图像路径
    @Select("select img from teacherimage where tno=#{tno}")
    String selTeaImgPath(String tno);
    //存储教师提交图片
    @Update("update teacherimage set img = #{relPath} where tno =#{userNo}")
    Integer insTeaPicByUserNo(@Param("userNo") String userNo,@Param("relPath") String relPath);
    //存储教师修改信息
    @Update("update userinfo set password=#{password},userName=#{userName},sex=#{sex} where userNo=#{userNo} and position='tea'")
    Integer saveTeaMsg(TeaChangeMsg teaChangeMsg);
    //查询教师名单
    List<TeaEva> selTeachers(UserDate teaDate);
    @Select("select * from teaevaluate where tno=#{userNo} and evatno=#{tno}")
    Integer selTeaEvaFlag(@Param("userNo") String userNo, @Param("tno") String tno);

    @Select("select * from tea_quota")
    List<Quota> selQuotaItems();

    Integer saveTeaEva(@Param("datas") List<TeaEvaData> data);

    @Select("select * from teaevaluate,tea_quota WHERE teaevaluate.qutaId=tea_quota.id and tno=#{tno} and evatno=#{evatno}")
    List<Quota> getTeaEvaDatas(@Param("tno") String userNo,@Param("evatno") String tid);

    @Select("SELECT quotaName,avg(qutaValue) qutaValue from stuevaluate,quota where stuevaluate.qutaId = quota.Id and tno=#{tno} GROUP BY tno,qutaId")
    List<Map<String,String>> getAll(String tno);
    @Select("SELECT quotaName,avg(qutaValue) qutaValue from stuevaluate,quota where stuevaluate.qutaId = quota.Id and tno=#{tno} GROUP BY tno,qutaId")
    List<Quota>getAll2Bean(String tno);

    @Select("SELECT quotaName,avg(qutaValue) qutaValue from teaevaluate,tea_quota where teaevaluate.qutaId = tea_quota.Id and tno=#{tno} GROUP BY tno,qutaId")
    List<Quota>getTeaAllQuota(String tno);

    @Select("SELECT sno,sname,className,classinfo.Id cid FROM stucourse,teaching,userinfo,classinfo where stucourse.courseId=teaching.courseId and stucourse.sno=userinfo.userNo and userinfo.classNo=classinfo.Id and teacherId = #{tno}")
    List<Map<String,String>> getAllStu(String tno);
}
