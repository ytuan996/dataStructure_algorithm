package com.ytuan.java.algorithm;

/**
 * <p>
 * 插入排序
 * </p>
 * <p>
 * 基本思想：将一个记录插入到已经排好序的有序表中，从而得到一个新的记录数加一的有序表
 * </p>
 * <p>
 * 时间复杂度分析：根据程序InsertSelect2，在最好的情况下，也就是数据本身有序，需要比较 n - i 次，无需移动
 * 累加起来也就是O(n);在最坏的情况下，数据是逆序的，需要比较 (n - 1)(n - i) 次，数据移动也要达到最大值，
 * 那么时间复杂度就是 n 的平方。
 * </p>
 *
 * @Author: ytuan
 * @Date: 2019-08-30  00:27
 */
public class InsertSorted {

    public static void main(String[] args) {

        InsertSorted insertSorted = new InsertSorted();

        int arr[] = new int[]{0, 9, 1, 5, 8, 3, 7, 4, 6, 2};

        insertSorted.insertSorted2(arr);

    }

    /**
     * 从第二个位置开始循环将当前记录插入到前面已经有序的记录表中
     *
     * @Author: ytuan
     * @Date: 2019-08-30  00:37
     */
    public void insertSorted(int arr[]) {

        if (arr == null || arr.length == 0)
            return;

        int len = arr.length;

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 常规方式的一点优化，针对几乎有序的记录表，减少移动的次数
     *
     * @Author: ytuan
     * @Date: 2019-08-30  00:37
     */
    public void insertSorted2(int arr[]) {

        if (arr == null || arr.length == 0)
            return;

        int len = arr.length;

        for (int i = 1; i < len; i++) {

            int ele = arr[i];

            // 当前记录ele的位置下标
            int j;

            for (j = i; j > 0 && arr[j - 1] > ele; j--)
                arr[j] = arr[j - 1];

            arr[j] = ele;

            ArrayUtils.printArray(arr);
            System.out.println();
        }
    }
}
