package com.ytuan.java.algorithm;

/**
 * <p>
 * 选择排序
 * </p>
 * <p>
 * 基本思想：循环，每一趟在 n - i + 1(i = 1, 2 , 3 ...) 个记录中选择最小的一个作为第 i 个记录
 * </p>
 * <p>
 * 时间复杂度分析：无论情况好坏，在第 i 趟，都需要进行 n - i 次比较，那么总共就需要 n * (n - 1) / 2 次，
 * 然后数据如果有序，则无需交换，但是降序排列时，需要交换 n - 1 次，总的来说，选择排序的时间复杂度为 n 的平方。
 * </p>
 *
 * @Author: ytuan
 * @Date: 2019-08-30  00:03
 */
public class SelectSorted {

    public static void main(String[] args) {

        SelectSorted selectSorted = new SelectSorted();

        int arr[] = new int[]{6, 4, 8, 7, 5};
        selectSorted.selectSorted(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    /**
     * @Author: ytuan
     * @Date: 2019-08-30  00:20
     */
    public void selectSorted(int arr[]) {

        int i = 0;
        int j = 0;
        int min = 0;

        int len = arr.length;

        for (i = 0; i < len; i++) {
            min = i;
            for (j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                ArrayUtils.swap(arr, i, min);
            }

            ArrayUtils.printArray(arr);
            System.out.println();
        }
    }

}
