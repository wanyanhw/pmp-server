package com.wyhw.pmp.util.pdf;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.catalina.core.ApplicationContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * 模板生成pdf
 */
public class TemplatePDFCreator {

    public OutputStream build(String path, String fileName, Map<String, String> argMap) throws Exception {
        PdfReader pdfReader = null;
        PdfStamper pdfStamper = null;
        try {
            pdfReader = new PdfReader(path + fileName);

            String root = "";

            File outFile = new File(root);
            pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(outFile));

            AcroFields acroFields = pdfStamper.getAcroFields();
            for (String  k : argMap.keySet()) {
                acroFields.setField(k, argMap.get(k));
            }
            pdfStamper.setAnnotationFlattening(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pdfStamper != null) {
                pdfStamper.close();
            }
            if (pdfReader != null) {
                pdfReader.close();
            }
        }
        return null;
    }
}
