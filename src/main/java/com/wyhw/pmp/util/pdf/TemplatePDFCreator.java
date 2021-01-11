package com.wyhw.pmp.util.pdf;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板生成pdf
 */
public class TemplatePDFCreator {

    private static void build(String path, String fileName, Map<String, String> argMap) throws Exception {
        // 设置中文字体
        BaseFont bfCn = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H", false);

        PdfReader pdfReader = null;
        PdfStamper pdfStamper = null;
        try {
            pdfReader = new PdfReader(path + File.separator + fileName);

            String targetFileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".pdf";

            String root = path + File.separator + targetFileName;
            File outFile = new File(root);
            pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(outFile));

            AcroFields acroFields = pdfStamper.getAcroFields();
            acroFields.addSubstitutionFont(bfCn);
            for (String  k : argMap.keySet()) {
                acroFields.setField(k, argMap.get(k));
            }
            pdfStamper.setFormFlattening(true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pdfStamper != null) {
                pdfStamper.flush();
                pdfStamper.close();
            }
            if (pdfReader != null) {
                pdfReader.close();
            }
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\lynn\\Desktop";
        String fileName = "template_test.pdf";
        Map<String, String> argMap = new HashMap<>();
        argMap.put("name", "小王");
        argMap.put("sex", "男");
        try {
            build(path, fileName, argMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
