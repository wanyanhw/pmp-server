package com.wyhw.pmp.ffmepg;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.junit.Test;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;
import ws.schild.jave.info.AudioInfo;
import ws.schild.jave.info.MultimediaInfo;
import ws.schild.jave.info.VideoInfo;
import ws.schild.jave.info.VideoSize;

import javax.swing.*;
import java.io.File;


/**
 * @author wanyanhw
 * @date 2022/6/14 11:03
 */
public class FFmpegTest {

    @Test
    public void getInfo() {
        try {
            MultimediaObject multimediaObject = new MultimediaObject(new File("C:\\Users\\wanyanhw\\Desktop\\htys.qlv"));
            MultimediaInfo info = multimediaObject.getInfo();
            AudioInfo audio = info.getAudio();
            VideoInfo video = info.getVideo();


            VideoAttributes videoAttributes = new VideoAttributes();
            videoAttributes.setCodec("hevc");
            videoAttributes.setBitRate(235000);
            videoAttributes.setFrameRate(30);
            videoAttributes.setSize(new VideoSize(720, 1280));

            AudioAttributes audioAttributes = new AudioAttributes();
            audioAttributes.setCodec("aac");
            audioAttributes.setBitRate(64000);
            audioAttributes.setSamplingRate(48000);
            audioAttributes.setChannels(2);

            EncodingAttributes encodingAttributes = new EncodingAttributes();
            encodingAttributes.setOutputFormat("mp4");
            encodingAttributes.setVideoAttributes(videoAttributes);
            encodingAttributes.setAudioAttributes(audioAttributes);

            Encoder encoder = new Encoder();
            encoder.encode(multimediaObject, new File("e:\\temp.mp4"), encodingAttributes);

        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void playVideo() throws Exception {
        File file = new File("C:\\Users\\wanyanhw\\Pictures\\ship.mp4");
        File file2 = new File("C:\\Users\\wanyanhw\\Pictures\\ship2.mp4");
        if (!file2.exists()) {
            file2.createNewFile();
        }

        JFrame window = new JFrame();
        window.setSize(800, 800);
        JLabel jLabel = new JLabel();
        window.add(jLabel);
        window.setVisible(true);

        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(file);
        grabber.start();

        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(file2, grabber.getAudioChannels());
        recorder.setImageWidth(grabber.getImageWidth());
        recorder.setImageHeight(grabber.getImageHeight());
        recorder.setVideoCodec(grabber.getVideoCodec());
        recorder.setAudioCodec(grabber.getAudioCodec());
        recorder.setVideoBitrate(grabber.getVideoBitrate());
        recorder.setFrameRate(25);
        recorder.setMaxBFrames(0);
        recorder.start();
        while (true) {
            Frame f = grabber.grab();
            if (f != null) {
                recorder.record(f);
                continue;
            }
            grabber.close();
            break;
        }
        recorder.close();
    }
}
