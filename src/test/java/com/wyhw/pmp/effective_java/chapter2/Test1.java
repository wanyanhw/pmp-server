package com.wyhw.pmp.effective_java.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出最长对称字符串
 *
 * @author 完颜宏伟
 *
 */
public class Test1 {
    public static void main(String[] args) {
        // TODO 输出最长对称字符串：goog
        String input1 = "google";

        // TODO 输出3个最长对称字符串：aba/aca/ada
        String input2 = "abcda";

        // TODO 输出2个最长对称字符串：pop/upu，不会输出特殊字符的对称字符串p-p
        // 不知道是不是我理解的题意不对，以数字代表字符串“pop-upu”-“0123456”，最长对称字符串应包含：012（pop）、015（pop）、025（ppp）、045（pup）、245（pup）、456（upu）
        String input3 = "pop-upu";
        getLongestStrs(input3);
    }

    private static void getLongestStrs(String input) {
        // 去除特殊字符‘-’
        input = input.replace("-", "");
        char[] chars = input.toCharArray();
        int length = chars.length;
        int maxLeftIndex = 0;
        int minRightIndex = 0;
        // 最大对称字符串长度
        int maxLength = 0;
        // 结果集
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = length - 1, n = i; j > n; j--) {
                if (chars[n] == chars[j]) {
                    sb.append(chars[n]);
                    maxLeftIndex = n;
                    minRightIndex = j;
                    n ++;
                }
            }
            StringBuilder resultSb = new StringBuilder(sb);
            StringBuilder reverseSb = new StringBuilder(sb.reverse());
            if (maxLeftIndex + 1 == minRightIndex) {
                StringBuilder result = resultSb.append(reverseSb);
                resultList.add(result.toString());
                if (result.length() > maxLength) {
                    maxLength = result.length();
                }
            } else {
                for (int k = maxLeftIndex + 1; k < minRightIndex; k++) {
                    StringBuilder tempSb = new StringBuilder(resultSb);
                    resultSb.append(chars[k]);
                    StringBuilder result = resultSb.append(reverseSb);
                    resultList.add(result.toString());
                    if (result.length() > maxLength) {
                        maxLength = result.length();
                    }
                    resultSb = tempSb;
                }
            }
        }

        int finalMaxLength = maxLength;
        resultList.forEach(item -> {
            if (item.length() == finalMaxLength) {
                System.out.println(item);
            }
        });

    }

    private static void midFind(String input) {
        String str = handleStr(input);
        int[] halfLenArr = new int[str.length()];
        int maxHalfLen = 0;
        for (int i = 0; i < str.length(); i++) {
            String str1 = getPalindrome(str, i, i);
            String str2 = getPalindrome(str, i, i + 1);

            String longerStr;
            if (str1.length() > str2.length()) {
                longerStr = str1;
            } else {
                longerStr = str2;
            }
            int len = halfLenArr[i] = longerStr.length() / 2;
            if (len > maxHalfLen) {
                maxHalfLen = len;
            }
        }

        System.out.println("最长回文：");
        for (int i = 0; i < halfLenArr.length; i++) {
            StringBuilder sb1 = new StringBuilder();
            if (halfLenArr[i] == maxHalfLen) {
                sb1.append(str, i - (halfLenArr[i] - 1), i + halfLenArr[i]);
                String s = removeChar(sb1.toString()).toString();
                System.out.println(s);
            }
        }
    }

    private static StringBuilder removeChar(String toString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < toString.toCharArray().length; i+=2) {
            sb.append(toString.charAt(i));
        }
        return sb;
    }

    /**
     * 获取以begin为中心的回文串
     * @param input 用户输入
     * @param begin 回文串起始位置
     * @param end 回文串结束位置
     * @return result 回文字符串
     */
    private static String getPalindrome(String input, int begin, int end) {
        while (begin >= 0 && end < input.length() && input.charAt(begin) == input.charAt(end)) {
            begin --;
            end ++;
        }
        return input.substring(begin + 1, end);
    }

    /**
     * 预处理字符串，首位和每个字符中间加入特殊符号‘#’
     * @param input 用户输入
     * @return result
     */
    private static String handleStr(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            sb.append(aChar);
            sb.append("#");
        }
        return sb.toString();
    }

}
