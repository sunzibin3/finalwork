package com.sun.finalwork.mapper;

import com.sun.finalwork.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from course where insid = #{insId} and id not in(select courseId from teaching where classid = #{classId})")
    List<Course> selCourseByInsId(@Param("insId") Integer insId, @Param("classId") String classId);
}
