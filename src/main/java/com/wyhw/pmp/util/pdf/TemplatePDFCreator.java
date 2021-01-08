package com.wyhw.pmp.util.pdf;

import com.itextpdf.text.pdf.PdfReader;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 模板生成pdf
 */
public class TemplatePDFCreator {

    public OutputStream build(String path, String fileName, String[] args) {
        PdfReader reader = null;
        try {
            reader = new PdfReader(path + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
