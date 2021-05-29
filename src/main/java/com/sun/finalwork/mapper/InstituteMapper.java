package com.sun.finalwork.mapper;

import com.sun.finalwork.pojo.Institute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface InstituteMapper {
    @Select("select * from institute")
    List<Institute> selAll();

    @Select("select * from dept where instituteId=#{id}")
    List<Map<String,String>> selDeptById(String id);
}
