package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.service.FileService;
import com.wyhw.pmp.util.MultipartFileUtils;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MultipartFileUtils fileUtils;

    @Override
    public boolean saveFile2Path(String target, String fileName, int chunkIndex, byte[] bytes) {
        fileName = fileName.replace(".", CHUNK_SEPARATOR + chunkIndex + ".");
        return fileUtils.saveFile(target, fileName, bytes);
    }

    @Override
    public boolean mergeSliceFile(String path, String fileName, int chunkTotal) {
        return fileUtils.mergeFile(path, fileName, CHUNK_SEPARATOR, chunkTotal);
    }

    @Override
    public void play(String path) {
        try {
            FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(path);
            grabber.setOption("rtsp_transport", "tcp"); // 使用tcp的方式，不然会丢包很严重
            // 一直报错的原因！！！就是因为是 2560 * 1440的太大了。。
            grabber.setImageWidth(960);
            grabber.setImageHeight(540);
            System.out.println("grabber start");
            grabber.start();
            CanvasFrame canvasFrame = new CanvasFrame("LIVE");
            canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvasFrame.setAlwaysOnTop(true);
            OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
            // OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
            while (true){
                Frame frame = grabber.grabImage();
                opencv_core.Mat mat = converter.convertToMat(frame);
                canvasFrame.showImage(frame);
            }
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
    }

    static Map<String, Frame> FLUSH_BOX = new HashMap<>();

    public static void main(String[] args) {
        try {
            String path = "rtmp://58.200.131.2:1935/livetv/hunantv";
            FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(path);
            grabber.setOption("rtsp_transport", "tcp"); // 使用tcp的方式，不然会丢包很严重
            // 一直报错的原因！！！就是因为是 2560 * 1440的太大了。。
            grabber.setImageWidth(960);
            grabber.setImageHeight(540);
            System.out.println("grabber start");
            grabber.start();
            CanvasFrame canvasFrame = new CanvasFrame("LIVE");
            canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvasFrame.setAlwaysOnTop(true);
            OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
            // OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
            long i = 0;
            while (i <= 500){
                System.out.println(i);
                Frame frame = grabber.grabImage();
                FLUSH_BOX.put( i++ + "", frame);
            }

            long j = 0;
            while (i > 0){
                Frame frame = FLUSH_BOX.get(j ++ + "");
                opencv_core.Mat mat = converter.convertToMat(frame);
                canvasFrame.showImage(frame);
                System.out.println(i --);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
