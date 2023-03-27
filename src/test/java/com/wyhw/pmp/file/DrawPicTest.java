package com.wyhw.pmp.file;

import com.wyhw.pmp.util.DateUtil;
import org.junit.Test;
import org.springframework.util.ObjectUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author wanyanhw
 * @since 2021/12/7 11:50
 */
public class DrawPicTest {

	@Test
	public void drawPic() {
		BufferedImage bi = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = (Graphics2D) bi.getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, bi.getWidth(), bi.getHeight());

		int xL = 500, yL = 170, lineHeight = 75, fontSize = 35;

		List<String> contents = new ArrayList<>();
		String today = DateUtil.format(new Date(), "yyyy-MM-dd");
		String title = "TODO " + today;
		contents.add("设备二维码应用流程图梳理 -- 已输出，需求待确认");
		contents.add("5.5.0 匹配图片数量降低至3个");
		contents.add("5.5.0 关键字批量维护功能");
		contents.add("5.5.0 关键词搜索系统素材（配图搜索逻辑）");
		contents.add("5.5.0 ESL商品图片和商品素材统一使用fastdfs组件管控");
		contents.add("5.5.0 素材空间限制大小，超过限制禁止上传");
		contents.add("Content 已有视频素材处理（处理旧视频文件未处理的补充方案） -- 暂不处理");
		contents.add("ES 词库完善-参考搜狗词库信息 -- 暂不处理");
		contents.add("视频自动转码处理优化方式调研（目前的方案太占用服务器资源） -- 暂不处理");

		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font(null, Font.BOLD, fontSize));
		graphics.drawString(title, xL, yL);
		for (int i = 0; i < contents.size(); i++) {
			graphics.drawString((i + 1) + "、" + contents.get(i), xL, yL + lineHeight * (i + 1));
		}

		String bgDic = "D:\\deskbg\\";
		String todayFileName = today + ".png";
		outPut(bi, bgDic + todayFileName);
		moveToHistory(bgDic, todayFileName);
	}

	private void moveToHistory(String bgDic, String todayFileName) {
		File file = new File(bgDic);
		if (!file.isDirectory()) {
			return;
		}
		File[] files = file.listFiles();
		for (File subFile : files) {
			if (subFile.isDirectory()) {
				continue;
			}
			String subFileName = subFile.getName();
			if (ObjectUtils.nullSafeEquals(subFileName, todayFileName)) {
				continue;
			}
			moveToHistory(subFile, bgDic + "history");
		}
	}

	private void moveToHistory(File subFile, String historyDic) {
		moveTo(subFile.getPath(), historyDic, true, true);
	}

	private static void outPut(BufferedImage bufferedImage, String path) {
		try {
			ImageIO.write(bufferedImage, "png", Files.newOutputStream(new File(path).toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void moveTo(String from, String to, boolean deleteOriginalFile, boolean ignoreEmptyFolderCreation) {
		File fromFile = new File(from);
		boolean directory = fromFile.isDirectory();
		if (directory) {
			String[] pathNames = fromFile.list();
			if (pathNames == null || pathNames.length == 0) {
				if (!ignoreEmptyFolderCreation) {
					new File(to).mkdir();
				}
				return;
			} else {
				new File(to).mkdirs();
			}
			Arrays.stream(pathNames).parallel().forEach(subPath -> {
				File subFile = new File(from + File.separator + subPath);
				if (subFile.isDirectory()) {
					moveTo(from + File.separator + subPath, to + File.separator + subPath, deleteOriginalFile, ignoreEmptyFolderCreation);
				} else {
					transferFileFromChannel(from + File.separator + subPath, to + File.separator + subFile.getName());
//                    saveFile(to, subFile, deleteOriginalFile);
				}
			});
			if (deleteOriginalFile) {
				fromFile.delete();
			}
			return;
		}
		transferFileFromChannel(from, to + File.separator + fromFile.getName());
		if (deleteOriginalFile) {
			fromFile.delete();
		}
	}

	private static void transferFileFromChannel(String from, String to) {
		try {
			RandomAccessFile fromAccess = new RandomAccessFile(from, "rw");
			FileChannel fromChannel = fromAccess.getChannel();

			RandomAccessFile toAccess = new RandomAccessFile(to, "rw");
			FileChannel toChannel = toAccess.getChannel();

			toChannel.transferFrom(fromChannel, 0L, fromChannel.size());
			fromChannel.close();
			toChannel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
