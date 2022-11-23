package com.wyhw.pmp.util;

import org.springframework.util.StringUtils;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 文本处理工具
 *
 * @author wanyanhw
 * @since 2021/9/15 13:55
 */
public class ContentHandleUtil {

	private static final Set<Character> CN_CHARACTER_SET = new HashSet<>(Arrays.asList('，', '。', '：', '！', '？', '；', '—'));
	private static final Set<Character> EN_CHARACTER_SET = new HashSet<>(Arrays.asList(',', '.', ':', '!', '?', ';', '-'));

	/**
	 * 设置分行数据列表
	 * @param f 字体样式
	 * @param width 单行最大宽度
	 * @param content 文本内容
	 * @param rowList 数据容器
	 */
	public static void setRowList(FontMetrics f, int width, String content, List<String> rowList) {
		if (StringUtils.isEmpty(content)) {
			return;
		}
		String sourceContent = content;
		content = subSuitableString(f, content, width);
		int[] index = theWholeWordLocationIndexWithBlankSuffix(sourceContent, content.length() - 1);
		if (index[0] != 0) {
			// 内容的单词数量大于 1
			// 此时需判断最后一个单词是否分居两行，若是，则将此单词完整置于下一行；否则继续拼接到当前行
			String withLastIndividualWord = sourceContent.substring(0, index[1] + 1);
			if (withLastIndividualWord.length() > content.length()) {
				// 单词分居两行
				content = sourceContent.substring(0, index[0]);
			} else {
				// 单词居于一行
				// 此时需判断单词后的第一个非空字符是否是标点符号，若是，则将此单词完整置于下一行，否则继续拼接到当前行
				int[] resultIndex = new int[1];
				char nextNotNullCharacter = nextChar(sourceContent, index[1], false, true, resultIndex);
				int nextNotNullCharacterIndex = resultIndex[0];
				if (nextNotNullCharacter != 0 && isPunctuation(nextNotNullCharacter)) {
					char lastNotNullCharacter = nextChar(sourceContent, index[1], false, false, resultIndex);
					if (lastNotNullCharacter != 0 && resultIndex[0] != -1 && isCnChar(lastNotNullCharacter)) {
						content = sourceContent.substring(0, nextNotNullCharacterIndex);
					} else {
						content = sourceContent.substring(0, index[0]);
					}
				} else {
					content = withLastIndividualWord;
				}
			}
		}
		// 去除首尾的空白后封装
		String trimContent = content.trim();
		if (!trimContent.isEmpty()) {
			rowList.add(trimContent);
		}

		if (content.length() < sourceContent.length()) {
			String targetContent;
			targetContent = sourceContent.substring(content.length());
			setRowList(f, width, targetContent, rowList);
		}
	}

	/**
	 * 当前索引位置的下一个字符
	 * @param sourceContent 源数据
	 * @param index 当前索引
	 * @param includeBlank 是否包含空
	 * @param next true-下一个，false-上一个
	 * @param resultIndex 结果索引
	 * @return char
	 */
	public static char nextChar(String sourceContent, int index, boolean includeBlank, boolean next, int[] resultIndex) {
		int length = sourceContent.length();
		index += (next ? 1 : -1);
		if (index == length) {
			resultIndex[0] = -1;
			return 0;
		}
		if (index > length || index < 0) {
			resultIndex[0] = -1;
			throw new ArrayIndexOutOfBoundsException();
		}
		char[] charArray = sourceContent.toCharArray();
		if (includeBlank) {
			resultIndex[0] = index;
			return charArray[index];
		}
		for (int i = index; i < charArray.length; ) {
			char c = charArray[i];
			resultIndex[0] = i;
			if (isEmpty(c)) {
				if (next) {
					i++;
				} else {
					i--;
				}
				continue;
			}
			return c;
		}
		resultIndex[0] = -1;
		return 0;
	}

	/**
	 * 判断字符是否是空
	 *
	 * 空字符范围(ASCII)：空格(32), 换行(10), 制表符(9)
	 *
	 * @param c 当前字符
	 * @return boolean
	 */
	public static boolean isEmpty(char c) {
		return c == 10 || c == 32 || c == 9;
	}

	/**
	 * 截取适当的字符串
	 * @param fontMetrics 字体指标
	 * @param content 文本内容
	 * @param maxWidth 最大宽度
	 * @return String 子字符串
	 */
	public static String subSuitableString(FontMetrics fontMetrics, String content, int maxWidth) {
		boolean unWrap = true;
		while (unWrap) {
			int contentWidth = fontMetrics.stringWidth(content);
			if (contentWidth > maxWidth && content.length() > 1) {
				content = content.substring(0, content.length() - 1);
				continue;
			}
			unWrap = false;
		}
		return content;
	}

	/**
	 * 判断是否为英文字符（不包括标点符号）
	 * @param c 字符，A-Z a-z
	 * @return boolean
	 */
	public static boolean isEnChar(char c) {
		return c >= 'A' && c <= 'Z' || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}

	/**
	 * 判断是否为中文字符(ASCII 码: 0x4E00-0x9FA5)
	 * @param c 字符
	 * @return boolean
	 */
	public static boolean isCnChar(char c) {
		return c >= 0X4E00 && c <= 0x9FA5;
	}

	/**
	 * 获取完整单词（单词后的空白数据也归属单词内容）
	 * 将带小数点的数值视为一个单词
	 *
	 * @param content 源文本内容
	 * @param currentIndex 当前索引
	 * @return int[0]-单词起始位置, int[1]-单词结束位置
	 */
	public static int[] theWholeWordLocationIndexWithBlankSuffix(String content, int currentIndex) {
		int headIndex = currentIndex;
		int tailIndex = currentIndex;
		char[] charArray = content.toCharArray();
		int len = charArray.length;

		char currentChar = charArray[currentIndex];

		boolean withBlankPrefix = false;
		boolean withBlankSuffix = false;
		if (currentChar == '.' || isNum(currentChar) || isEmpty(currentChar)) {
			while (headIndex >= 0 && isEmpty(charArray[headIndex])) {
				// 获取单词前面的空白
				headIndex --;
				withBlankPrefix = true;
			}
			if (withBlankPrefix) {
				headIndex++;
			}
			// 当前位置若为'.'或数字时，判断是否为浮点型数值
			if (currentChar == '.') {
				if ((currentIndex > 0 && isNum(charArray[currentIndex - 1])) && (currentIndex < len - 2 && isNum(charArray[currentIndex + 1]))) {
					do {
						headIndex--;
					} while (headIndex >= 0 && isNum(charArray[headIndex]));
					headIndex++;

					do {
						tailIndex++;
					} while (tailIndex < len && isNum(charArray[tailIndex]));
					tailIndex--;

					while (tailIndex < len && isEmpty(charArray[tailIndex])) {
						// 获取单词后面的空白
						tailIndex ++;
						withBlankSuffix = true;
					}
					if (withBlankSuffix) {
						tailIndex--;
					}
					return new int[]{headIndex, tailIndex};
				}
			} else if (isNum(currentChar)) {
				boolean findPoint = false;
				do {
					headIndex --;
					if (headIndex < 0) {
						break;
					}
					if (findPoint && !isNum(charArray[headIndex])) {
						break;
					}
					if (charArray[headIndex] == '.') {
						if (headIndex == 0 || !isNum(charArray[headIndex - 1])) {
							// 小数点开头或小数点前一位不是数字，结束循环
							break;
						}
						findPoint = true;
						headIndex --;
					}
				} while (headIndex >=0 && isNum(charArray[headIndex]));
				headIndex ++;

				do {
					tailIndex ++;
					if (tailIndex >= len) {
						break;
					}
					if (findPoint && !isNum(charArray[tailIndex])) {
						break;
					}
					if (charArray[tailIndex] == '.') {
						if (tailIndex == len - 1 || !isNum(charArray[tailIndex + 1])) {
							// 小数点结尾或小数点后一位不是数字，结束循环
							break;
						}
						findPoint = true;
						tailIndex ++;
					}
				} while (isNum(charArray[tailIndex]));
				tailIndex --;

				while (tailIndex < len && isEmpty(charArray[tailIndex])) {
					// 获取单词后面的空白
					tailIndex ++;
					withBlankSuffix = true;

				}
				if (withBlankSuffix) {
					tailIndex--;
				}
				return new int[] {headIndex, tailIndex};
			}
		}

		headIndex = currentIndex;
		tailIndex = currentIndex;
		// 向前识别空白 + 英文字符
		while (headIndex >= 0 && isEmpty(charArray[headIndex])) {
			headIndex --;
		}
		while (headIndex >= 0 && isEnChar(charArray[headIndex])) {
			headIndex --;
		}
		if (headIndex == tailIndex) {
			return new int[] {headIndex, tailIndex};
		}
		headIndex ++;

		// 向后识别英文字符 + 空白
		while (tailIndex < len && isEnChar(charArray[tailIndex])) {
			tailIndex ++;
		}
		while (tailIndex < len && isEmpty(charArray[tailIndex])) {
			tailIndex ++;
		}
		tailIndex --;
		return new int[] {headIndex, tailIndex};
	}

	/**
	 * 判断是否为数字字符
	 * @param thisChar 当前字符
	 * @return boolean
	 */
	private static boolean isNum(char thisChar) {
		return thisChar >= '0' && thisChar <= '9';
	}

	/**
	 * 标点符号判断
	 * @param c 字符
	 * @return boolean
	 */
	public static boolean isPunctuation(char c) {
		return isEnPunctuation(c) || isCnPunctuation(c);
	}

	/**
	 * 中文标点判断
	 * @param c 字符
	 * @return boolean
	 */
	public static boolean isCnPunctuation(char c) {
		return CN_CHARACTER_SET.contains(c);
	}

	/**
	 * 英文标点判断
	 * @param c 字符
	 * @return boolean
	 */
	public static boolean isEnPunctuation(char c) {
		return EN_CHARACTER_SET.contains(c);
	}

	/**
	 * 格式化小数格式的数据（至少保留两位小数）
	 *
	 * 1、若小数位小于2位，保留2位小数，{eg: 0.1 -> 0.10; 21 -> 21.00; 5.01 -> 5.01}
	 * 2、若小数位大于2位，保留至最后1位非0位 {eg: 1.500 -> 1.50; 1.10200 -> 1.102}
	 * @param content 源数据
	 * @return String
	 */
	public static String formatDecimalContent(String content) {
		if (StringUtils.isEmpty(content)) {
			return "";
		}
		int sepIndex = content.indexOf(".");
		if (sepIndex == -1) {
			// 整数需要保留两位小数
			return content + ".00";
		}
		String[] split = content.split("\\.");
		String intStringV;
		try {
			intStringV = split[0];
		} catch (Exception e) {
			intStringV = "0";
		}
		if (StringUtils.isEmpty(intStringV)) {
			intStringV = "0";
		}
		String decStringV;
		try {
			decStringV = split[1];
		} catch (Exception e) {
			decStringV = "00";
		}
		int decV = Integer.parseInt(decStringV);
		if (decV == 0) {
			decStringV = "00";
		} else {
			char[] chars = decStringV.toCharArray();
			int lastNotZeroIndex = 0;
			for (int i = chars.length - 1; i >= 0; i--) {
				char c = chars[i];
				if (c == '0') {
					continue;
				}
				lastNotZeroIndex = i;
				break;
			}
			if (lastNotZeroIndex == 0) {
				decStringV = chars[0] + "0";
			} else {
				decStringV = decStringV.substring(0, lastNotZeroIndex + 1);
			}
		}
		return intStringV + "." + decStringV;
	}

	/**
	 * 处理小数格式数据，根据{@code thousand} 和 {@code decimal}分割数据
	 *
	 * @param content 源数据
	 * @param thousand 千位分隔符
	 * @param decimal 小数分隔符
	 * @return String
	 */
	public static String parsedDecimalContent(String content, String thousand, String decimal) {
		if (StringUtils.isEmpty(content)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		String[] split = content.split("\\.");
		sb.append(sepIntValue(split[0], thousand));
		sb.append(setDecValue(split[1], decimal));
		return sb.toString();
	}

	/**
	 * 设置小数格式数据
	 * @param decStringV 小数数据
	 * @param decimal 整数与小数之间的分隔符
	 * @return String
	 */
	public static String setDecValue(String decStringV, String decimal) {
		StringBuilder content = new StringBuilder();
		int decV = Integer.parseInt(decStringV);
		content.append(decimal);
		if (decV == 0) {
			content.append("00");
		} else {
			content.append(decStringV);
		}
		return content.toString();
	}

	/**
	 * 设置整数数据，每3位进行一次分隔
	 * @param intStringV 整数数据
	 * @param thousand 千位分隔符
	 * @return String
	 */
	public static String sepIntValue(String intStringV, String thousand) {
		StringBuilder content = new StringBuilder();
		char[] chars = intStringV.toCharArray();
		int index = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			if (index == 3) {
				content.append(thousand);
				index = 0;
			}
			index ++;
			content.append(chars[i]);
		}
		return content.reverse().toString();
	}
}
