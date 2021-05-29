package com.sun.finalwork.mapper;

import com.sun.finalwork.pojo.Teaching;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeachingMapper {
    @Insert("insert into teaching values(default,#{classId},#{courseId},#{teacherId},#{batchId})")
    Integer insTeaching(Teaching teaching);
}
