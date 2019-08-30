package com.ytuan.java.algorithm.search;

/**
 * <p>
 * comment:二分查找法
 * </p>
 * <p>
 * 基本思想：在有序表中，将中间值作为作为比较对象，若如目标值相等，则查找成功，否则在另外一半中查找,
 * 使用二分查找的前提条件是序列是有序的
 * </p>
 * <p>
 * 时间复杂度：O(logn)
 * </p>
 *
 * @author: ytuan
 * @Date 2019-08-30 23:14
 */
public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = new int[]{6, 8, 4, 3, 9, 7};
        int i = new BinarySearch().binarySearch(arr, 9);
        System.out.println(i);
    }

    /**
     * @param arr
     * @param target
     * @return
     */
    public int binarySearch(int[] arr, int target) {

        int low, high, mid;

        int len = arr.length;

        low = 0;
        high = len - 1;

        while (low <= high) {

            mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
