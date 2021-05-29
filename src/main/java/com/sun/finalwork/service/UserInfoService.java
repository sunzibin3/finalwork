package com.sun.finalwork.service;

import com.sun.finalwork.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    List<UserInfo> getAllStu();

    Integer delUser(String id);

    Integer updUser(UserInfo userInfo);

    Integer addUser(UserInfo userInfo);

    List<UserInfo> getAllTea();

    List<Map<String,String>>getTeaToMap();

    List<Map<String,String>>getTeaToMap(String msg,String userType);

    List<UserInfo> getUserByMsg(String msg, String userType);
}
