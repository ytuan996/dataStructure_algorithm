package com.ytuan.java.algorithm.search;

/**
 * <p>
 * comment:顺序表查找
 * </p>
 * <p>
 * 基本思想：从顺序表的第一个或者最后一个开始，一次和目标关键字比较，若想等，则查找成功，否则失败
 * </p>
 * <p>
 * 时间复杂度：每个元素一次比较，因此复杂度为O(n)
 * </p>
 *
 * @author: ytuan
 * @Date 2019-08-30 23:02
 */
public class SequentSearch {

    /**
     * 最简单的顺序查找方法
     *
     * @param arr
     * @param target
     * @return
     */
    public int sequentSearch(int[] arr, int target) {

        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param arr
     * @param target
     * @return
     */
    public int sequentSearch2(int[] arr, int target) {

        int len = arr.length;

        while (len > 0 && arr[len - 1] != target) {
            len--;
        }

        return len - 1;
    }
}
