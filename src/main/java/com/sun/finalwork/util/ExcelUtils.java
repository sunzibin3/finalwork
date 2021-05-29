package com.sun.finalwork.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static Workbook createWorkBook(List list, String getters[], String headers[], Class clazz){
        List<Method> methods = getMetodsBystr(getters,clazz);
        //创建工作簿
        Workbook wb = new XSSFWorkbook();
        //创建表
        Sheet sheet = wb.createSheet();
        // 手动设置列宽.第一个参数表示要为第几列设,第二个参数表示列的宽度,n为列高的像素数.
        for(int i=0;i<getters.length;i++){
            sheet.setColumnWidth((short)i,(short) (35.7 * 200) );
        }
        Row header = sheet.createRow(0);
        //创建两种单元格格式
        CellStyle style1 = wb.createCellStyle();
        CellStyle style2 = wb.createCellStyle();

        Font font = wb.createFont();//标题字体
        Font font1 = wb.createFont();//正文字体
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        setCellStype(style1, font);
        setCellStype(style2, font1);
        //设置标题
        for(int i=0;i<headers.length;i++){
            Cell cell = header.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style1);
        }
        //设置data
        int headerSum=1;
        int endHeader=1;
        for(int i=0;i<list.size();i++,endHeader++){
            Row row = sheet.createRow(i + headerSum);
            for(int j=0;j<methods.size();j++){
                Object o = null;
                try {
                    o = methods.get(j).invoke(list.get(i));
                    if(o!=null){
                        row.createCell(j).setCellValue(o.toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return wb;
    }


    /**
     * 设置格式
     * @param cellStyle
     * @param font
     */
    private static void setCellStype(CellStyle cellStyle, Font font) {
        font.setFontHeightInPoints((short) 10);
        font.setColor(IndexedColors.BLACK.getIndex());
        cellStyle.setFont(font);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
    }

    /**
     * 获取对于类的get方法
     * @param getters 方法名
     * @param clazz 对于类
     * @return Method数组
     */
    private static List<Method> getMetodsBystr(String[] getters, Class clazz) {
        List<Method> lists = new ArrayList<>();
        for(String get:getters){
            try {
                lists.add(clazz.getDeclaredMethod(get));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return lists;
    }
}
