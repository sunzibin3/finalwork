package com.sun.finalwork.service.impl;

import com.sun.finalwork.bean.Quota;
import com.sun.finalwork.mapper.QuotaMapper;
import com.sun.finalwork.mapper.UserInfoMapper;
import com.sun.finalwork.pojo.UserInfo;
import com.sun.finalwork.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private QuotaMapper quotaMapper;

    @Override
    public List<Map<String,String>>getTeaToMap(){
        List<Map<String, String>> map = userInfoMapper.getTeaToMap();
        for(int i=0;i<map.size();i++){
            List<Map<String,Number>> list = quotaMapper.getQuota(map.get(i).get("userNO"));
            Double result=0.0;
            Double sum=0.0;
            for(Map<String,Number> maps:list){
                int weight =(Integer) maps.get("weight");
                String avgStr =maps.get("a").toString();
                double avg = Double.parseDouble(avgStr);
                result = weight*avg;
                sum = sum+result;
            }
            Double avg = sum/list.size();
            DecimalFormat df = new DecimalFormat("#.00");
            String s = df.format(avg);
            map.get(i).put("value",s);
        }
        return map;
    }

    @Override
    public List<Map<String, String>> getTeaToMap(String msg, String userType) {
        List<Map<String, String>> map = userInfoMapper.getTeaToMapByLike(msg,userType);
        for(int i=0;i<map.size();i++){
            List<Map<String,Number>> list = quotaMapper.getQuota(map.get(i).get("userNO"));
            Double result=0.0;
            Double sum=0.0;
            for(Map<String,Number> maps:list){
                int weight =(Integer) maps.get("weight");
                String avgStr =maps.get("a").toString();
                double avg = Double.parseDouble(avgStr);
                result = weight*avg;
                sum = sum+result;
            }
            Double avg = sum/list.size();
            DecimalFormat df = new DecimalFormat("#.00");
            String s = df.format(avg);
            map.get(i).put("value",s);
        }
        return map;
    }

    @Override
    public List<UserInfo> getAllStu() {
        return userInfoMapper.getUserInfoByPosition("stu");
    }

    @Override
    public Integer delUser(String id) {
        return userInfoMapper.delUserInfoById(id);
    }

    @Override
    public Integer updUser(UserInfo userInfo) {
        return userInfoMapper.updUserInfoById(userInfo);
    }

    @Override
    public Integer addUser(UserInfo userInfo) {
        return userInfoMapper.addUser(userInfo);
    }

    @Override
    public List<UserInfo> getAllTea() {
        return userInfoMapper.getUserInfoByPosition("tea");
    }

    @Override
    public List<UserInfo> getUserByMsg(String msg, String userType) {
        return userInfoMapper.getAllByMsg(msg,userType);
    }

}
