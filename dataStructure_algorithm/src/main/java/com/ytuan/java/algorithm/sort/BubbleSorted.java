package com.ytuan.java.algorithm.sort;

/**
 * 冒泡排序；即是一种交换排序
 * <p>
 * 基本思想：两两比较相邻记录的关键字，如果反序就交换位置。直到没有反序为止。
 * </p>
 * <p>
 * 此处提供三种冒泡排序的实现
 * </p>
 * <p>
 * 时间复杂度分析：根据way3，在最好的情况下，数据本身就是有序的，需要 n - 1 此比较，
 * 那么复杂度就是 O(n);在最坏的情况下，数据都是逆序的，那么需要比较 n * (n - 1) / 2 次，
 * 也就是 n 的 平方。
 * </p>
 *
 * @Author: ytuan
 * @Date: 2019-08-29  23:01
 */
public class BubbleSorted {

    public static void main(String[] args) {

        BubbleSorted bubbleSorted = new BubbleSorted();

        int arr[] = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        bubbleSorted.bubbleWay3(arr);

    }

    /**
     * 循环：每次和后一个关键字比较，较大就交换
     * 每一次只是将当前关键字排在最终位置，而不考虑其他关键字的位置
     *
     * @param arr
     * @Author: ytuan
     * @Date: 2019-08-29  23:14
     */
    public void bubbleWay1(int arr[]) {

        if (arr == null || arr.length == 0)
            return;

        int i = 0;
        int j = 0;

        // 下标范围 [0,len - 1]
        int len = arr.length;

        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                if (arr[j] < arr[i]) {
                    ArrayUtils.swap(arr, j, i);
                }
            }

            ArrayUtils.printArray(arr);

            System.out.println();
        }
    }

    /**
     * 从 len - 1 往前依次循环到 0, 1 ,2, ...小的靠前，一次循环就把整体较小的都往前移动
     *
     * @Author: ytuan
     * @Date: 2019-08-29  23:31
     */
    public void bubbleWay2(int arr[]) {

        if (arr == null || arr.length == 0)
            return;

        int i = 0;
        int j = 0;

        int len = arr.length;

        for (i = 0; i < len; i++) {
            for (j = len - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    ArrayUtils.swap(arr, j, j - 1);
                }
            }

            ArrayUtils.printArray(arr);
            System.out.println();
        }
    }

    /**
     * 词此实现方法是在way2的基础上做的一步优化，主要针对几乎有序的数组，减少循环的次数
     *
     * @Author: ytuan
     * @Date: 2019-08-29  23:41
     */
    public void bubbleWay3(int arr[]) {

        if (arr == null || arr.length == 0)
            return;

        int i = 0;
        int j = 0;

        //标识关键字是否交换过
        boolean isSwap = true;

        int len = arr.length;

        for (i = 0; i < len && isSwap; i++) {
            isSwap = false;
            for (j = len - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    ArrayUtils.swap(arr, j, j - 1);
                    isSwap = true;
                }
            }

            ArrayUtils.printArray(arr);
            System.out.println();
        }
    }
}
