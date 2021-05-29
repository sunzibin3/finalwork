package com.sun.finalwork.service;

import com.sun.finalwork.bean.EvaluateTeachers;
import com.sun.finalwork.bean.Quota;
import com.sun.finalwork.bean.StuChartMsg;
import com.sun.finalwork.bean.UserDate;
import com.sun.finalwork.bean.teacher.MsgDates;
import com.sun.finalwork.bean.teacher.TeaChangeMsg;
import com.sun.finalwork.bean.teacher.TeaEva;
import com.sun.finalwork.bean.teacher.TeaEvaData;

import java.util.List;

public interface TeacherService {
    List<StuChartMsg> selChartMsg(String teaRoomNo);
    //获取未读信息个数
    Integer getStuMsgNum(String tno);
    //获取学生留言列表
    List<MsgDates> getStuMsg(String tno);
    //更新留言表状态
    Integer updStuMsgFlag(Integer id);
    //获取教师图像路径
    String selTeaImg(String tno);

    /**
     * 保存图片路径到数据库
     * @param userNo 教师编号
     *         relPath 文件名
     * @return
     */
    Integer savePic(String userNo,String relPath);

    /**
     * 保存教师修改信息
     * @param teaChangeMsg
     * @return
     */
    Integer saveTeaMsg(TeaChangeMsg teaChangeMsg);


    /**
     * 查找教师名单
     * @param teaDate
     * @return
     */
    List<TeaEva> selTeachers(UserDate teaDate);

    /**
     * 查询是否对该教师已经评价
     * @param userNo
     * @param tno
     * @return
     */
    Integer selTeaEvaFlag(String userNo, String tno);

    /**
     * 查询评价项
     * @return
     */
    List<Quota> selQuotaItems();

    /**
     * 持久化评价信息
     * @param data
     * @return
     */
    Integer saveTeaEva(List<TeaEvaData> data);

    /**
     * 获取评价信息
     * @param userNo
     * @param tid
     * @return
     */
    List<Quota> getTeaEvaDatas(String userNo, String tid);
}
