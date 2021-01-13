package com.wyhw.pmp.util.pdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

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

    private static void build(String templatePath, String templateName, String targetPath, String targetName, Map<String, String> argMap) throws Exception {
        // 设置支持中文字体
        BaseFont bfCn = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H", false);

        PdfReader pdfReader = null;
        PdfStamper pdfStamper = null;
        try {
            pdfReader = new PdfReader(templatePath + File.separator + templateName) ;
            File outFile = new File(targetPath + File.separator + targetName);
            pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(outFile));

            AcroFields acroFields = pdfStamper.getAcroFields();
            acroFields.addSubstitutionFont(bfCn);
            for (String  k : argMap.keySet()) {
                acroFields.setField(k, argMap.get(k));
            }
            pdfStamper.setFormFlattening(true);

            float x = 180, y = 300;
            Rectangle rectangle = new Rectangle(x, y);
            Image image = Image.getInstance(argMap.get("touxiang"));
            image.scaleToFit(rectangle);
            image.setAbsolutePosition(x, y);
            PdfContentByte overContent = pdfStamper.getOverContent(1);
            overContent.addImage(image);
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
        String templatePath = "C:\\Users\\lynn\\Desktop";
        String templateName = "template_test.pdf";

        String targetPath = "C:\\Users\\lynn\\Desktop";
        String targetName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")) + ".pdf";

        Map<String, String> argMap = new HashMap<>();
        argMap.put("name", "小王");
        argMap.put("sex", "男");
        argMap.put("touxiang", "C:\\Users\\lynn\\Pictures\\lizhi.jpg");

        try {
            build(templatePath, templateName, targetPath, targetName, argMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
