package com.sun.finalwork.controller;

import com.sun.finalwork.bean.Quota;
import com.sun.finalwork.bean.ceshi;
import com.sun.finalwork.mapper.TeacherMapper;
import com.sun.finalwork.util.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DownLoadController {
    @Autowired
    private TeacherMapper teacherMapper;

    @RequestMapping("/ttest")
    public ResponseEntity<byte[]> exportExcel(String tno,String tname,String avg){
        List<Quota> list = teacherMapper.getAll2Bean(tno);
        List<Quota> teaAllQuota = teacherMapper.getTeaAllQuota(tno);
        list.addAll(teaAllQuota);
        list.add(new Quota("平均分",avg));
        String fileName = tname+"评价情况信息表";
        String[] getters = {"getQuotaName", "getQutaValue"};
        String[] headers = {"评价项", "评分"};

        Workbook workBook = ExcelUtils.createWorkBook(list, getters, headers,new Quota().getClass());
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            workBook.write(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert bos != null;
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileName=URLEncoder.encode(fileName, "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] bytes = bos.toByteArray();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", fileName+".xlsx");
        return new ResponseEntity<byte[]>(bytes,httpHeaders,HttpStatus.OK);
    }



    /*@RequestMapping("/exportExcel")
    public ResponseEntity<byte[]> exportExcel(){
        ceshi student1 = new ceshi("张三", 90, 18);
        ceshi student2 = new ceshi("李四", 85, 17);
        ceshi student3 = new ceshi("王五", 70, 19);
        List<ceshi> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        String fileName = "学生成绩统计表";
        String[] getters = {"getName", "getScore", "getAge"};
        String[] headers = {"姓名", "分数", "年龄"};
        Workbook workBook = ExcelUtils.createWorkBook(list, getters, headers, new ceshi().getClass());
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            workBook.write(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert bos != null;
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileName=URLEncoder.encode(fileName, "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] bytes = bos.toByteArray();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", fileName+".xlsx");
        return new ResponseEntity<byte[]>(bytes,httpHeaders,HttpStatus.OK);
    }*/
}
