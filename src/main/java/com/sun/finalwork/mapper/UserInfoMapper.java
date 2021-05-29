package com.sun.finalwork.mapper;

import com.sun.finalwork.pojo.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {
    @Select("select * from userinfo")
    List<UserInfo> getAll();

    List<Map<String,String>> getTeaToMap();

    List<Map<String,String>> getTeaToMapByLike(@Param("msg") String msg,@Param("userType")String userType);

    @Select("select * from userinfo left join classinfo on userinfo.classNo=classinfo.Id where position = #{position}")
    List<UserInfo> getUserInfoByPosition(String position);
    @Delete("DELETE from userinfo where id = #{id}")
    Integer delUserInfoById(String id);

    Integer updUserInfoById(UserInfo userInfo);

    Integer addUser(UserInfo userInfo);

    List<UserInfo> getAllTea();

    //模糊查询
    @Select("SELECT * from userinfo where userName LIKE #{msg} and position=#{type}")
    List<UserInfo> getAllByMsg(@Param("msg") String Msg, @Param("type") String userType);
    @Select("select * from userinfo where classNo=#{key} and position='stu'")
    List<Map<String,String>>  getStuToMapByClass(String key);
}
