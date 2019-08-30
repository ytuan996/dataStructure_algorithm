package com.ytuan.java.algorithm;

/**
 * <p>
 * comment:希尔排序
 * </p>
 * <p>
 * 基本思想：将相距某个增量的记录组成子序列，在子序列内执行插入排序使用子序列基本有序
 * 最后再执行一次插入排序使序列全部有序
 * </p>
 * <p>
 * 时间复杂度分析：增量序列在范围 0 ~ log2(n + 1), 复杂度为 n 的 3/2 次方， 稍快于插入排序
 * </p>
 *
 * @author: ytuan
 * @Date 2019-08-30 08:24
 */
public class ShellSorted {

    public static void main(String[] args) {

        ShellSorted shellSorted = new ShellSorted();

        int arr[] = new int[]{0, 9, 1, 5, 8, 3, 7, 4, 6, 2};

        shellSorted.shellSorted(arr);

    }

    public void shellSorted(int[] arr) {

        int i, j;

        // 每次排序的步数，也就是增量，即排序子序列的记录数
        int increment = arr.length;

        int len = arr.length;

        do {
            increment = increment / 3 + 1;

            for (i = increment + 1; i < len; i++) {
                // 当前记录和前面第 increment 个记录比较，若较小，执行向前插入
                if (arr[i] < arr[i - increment]) {
                    int ele = arr[i];

                    for (j = i - increment; j > 0 && arr[j] > ele; j -= increment)
                        arr[j + increment] = arr[j];

                    arr[j + increment] = ele;
                }
            }

            ArrayUtils.printArray(arr);
            System.out.println();

        } while (increment > 1);
    }
}