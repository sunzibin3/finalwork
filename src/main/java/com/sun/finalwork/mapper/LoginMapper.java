package com.sun.finalwork.mapper;

import com.sun.finalwork.bean.User;
import com.sun.finalwork.bean.UserDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    /*@Select("select classNo from userinfo where userNo=#{userNo}and password=#{password} and userType=#{userType}")
    Integer selStudent(User user);*/
    @Select("select * from userinfo where userNo=#{userNo}and password=#{password} and userType=#{userType}")
    UserDate selStudent(User user);
}
