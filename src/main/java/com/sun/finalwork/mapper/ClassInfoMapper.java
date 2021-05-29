package com.sun.finalwork.mapper;

import com.sun.finalwork.pojo.ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassInfoMapper {
    @Select("select * from classinfo")
    List<ClassInfo> getAll();

    @Select("select * from classinfo where deptId = #{id}")
    List<ClassInfo> getAllByDepId(String id);
}
