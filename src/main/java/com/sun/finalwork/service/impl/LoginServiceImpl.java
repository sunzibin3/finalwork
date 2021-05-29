package com.sun.finalwork.service.impl;

import com.sun.finalwork.bean.User;
import com.sun.finalwork.bean.UserDate;
import com.sun.finalwork.mapper.LoginMapper;
import com.sun.finalwork.mapper.StudentMapper;
import com.sun.finalwork.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserDate getStuByUserNamePassowrd(User user) {
        return loginMapper.selStudent(user);
    }
}
