package com.wyhw.pmp.util.io;

import java.io.*;

public class LimitFileInputStream {

	final int BLOCK_SIZE = 2 * 1024 * 1024;
	long MAX_TRANSPORT_SPEED = 1024 * 1024;
	long MIN_TIME = BLOCK_SIZE / MAX_TRANSPORT_SPEED;

	public void upload(File file, boolean limit) {
		try (FileInputStream bis = new FileInputStream(file)) {
			try (FileOutputStream fos = new FileOutputStream(new File("E://" + file.getName()))) {
				long beginNano = System.nanoTime();
				byte[] b = new byte[BLOCK_SIZE];
				int r;
				while ((r = bis.read(b, 0, b.length)) != -1) {
					fos.write(b, 0, r);
					long endNano = System.nanoTime();
					long lastNano = endNano - beginNano;
					if (lastNano <= MIN_TIME * 1000000000 && limit) {
						long l = MIN_TIME * 1000000000 - lastNano;
						Thread.sleep(l / 1000000, 0);
					}
				}
				System.out.println("总耗时：" + (System.nanoTime() - beginNano) + " 纳秒");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LimitFileInputStream limitFileInputStream = new LimitFileInputStream();
		File file = new File("C:\\Users\\wanyanhw\\Desktop\\fsdownload\\zk_esl_release.jar");
		limitFileInputStream.upload(file, false);
		limitFileInputStream.upload(file, true);
	}
}
