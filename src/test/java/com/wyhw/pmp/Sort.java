package com.wyhw.pmp;

/**
 * 排序算法
 */
public class Sort {
    private static int[] NUMS = {5, 8, 12, 6, 0, 7, 9, 10, 2, 5};

    private static void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j ++) {
                if (nums[j] > nums[j + 1]) {
                    int tempInt = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tempInt;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("源数据：");
        printNums(NUMS);
        // 1、冒泡排序
        bubbleSort(NUMS);

        // 2、快速排序

        System.out.println("\n排序后：");
        printNums(NUMS);
    }

    private static void printNums(int[] nums) {
        for (int num : NUMS) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }
}
