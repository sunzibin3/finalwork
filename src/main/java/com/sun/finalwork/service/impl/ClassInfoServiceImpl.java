package com.sun.finalwork.service.impl;

import com.sun.finalwork.mapper.ClassInfoMapper;
import com.sun.finalwork.pojo.ClassInfo;
import com.sun.finalwork.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {
    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Override
    public List<ClassInfo> getAll() {
        return classInfoMapper.getAll();
    }
}
