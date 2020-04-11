package com.wyhw.pmp.util;

import org.apache.commons.collections4.map.LinkedMap;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

public class ExcelUtils {

    /**
     * 导出excel表格
     * @param response 响应体
     * @param fileName 文件名
     * @param titles 数据标题
     * @param dataMapList 数据列表
     */
    public void exportExcel(HttpServletResponse response, String fileName, String[] titles,
        List<LinkedMap> dataMapList) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("sheet1");

        int[] index = {0};
        HSSFRow row1 = sheet1.createRow(index[0]);
        for(int i = 0; i < titles.length; i ++) {
            row1.createCell(i).setCellValue(titles[i]);
        }

        dataMapList.forEach(item -> {
            HSSFRow row = sheet1.createRow(++index[0]);
            int[] mapSize = {0};
            item.forEach((k, v) -> {
                row.createCell(mapSize[0]++).setCellValue(v.toString());
            });
        });

        buildExcelFile(fileName, wb);

        downloadExcelFile(response, wb, fileName);

    }

    /**
     * 生成Excel文件
     */
    public void buildExcelFile(String fileName, HSSFWorkbook workbook) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 浏览器下载Excel文件
     */
    public void downloadExcelFile(HttpServletResponse response, HSSFWorkbook workbook, String fileName) {
        OutputStream outputStream = null;
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
            "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
