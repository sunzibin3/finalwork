package com.sun.finalwork.mapper;

import com.sun.finalwork.pojo.Institute;
import com.sun.finalwork.pojo.Quota;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuotaMapper {
    @Select("SELECT weight,avg(qutaValue) a from stuevaluate,quota where stuevaluate.qutaId = quota.Id and tno=#{tno} GROUP BY tno,qutaId")
    List<Map<String,Number>> getQuota(String tno);

    @Select("select * from quota where delFlag <> 1")
    List<Quota> getStuQuota();
    @Update("UPDATE quota SET weight = #{weight},isUsed=#{isUsed} WHERE id = #{id}")
    Integer saveChange(Quota quota);
    @Update("UPDATE quota SET delFlag = 1,isUsed = 0 WHERE id = #{id}")
    Integer delQuota(String id);
    @Update("UPDATE quota SET isUsed = 1 WHERE id = #{id}")
    Integer usedQuota(String string);

    @Insert("insert into quota values(default,#{quotaName},#{weight},#{isUsed},0)")
    Integer addQuota(Quota quota);
}
