package com.ytuan.java.algorithm;

/**
 * <p>
 * comment: 堆排序
 * </p>
 * <p>
 * 基本思想：将待排序的序列构建为一个最大堆，其根节点就是最大值，将其移动到最后，
 * 然后再将 n - 1 个序列构成为最大堆，直到整个序列有序
 * </p>
 * <p>
 * 时间复杂度分析：在堆排序中，主要分为初始堆的构建和调整位置后的堆重建。
 * 1. 在堆的构建中，从第一个非叶子节点开始，每个节点和其左右孩子比较和互换，整个过程时间复杂度为 O(n)
 * 2. 在调整位置的时候，重建堆花费 logn ，因为在完全二叉树中，某个节点到根节点时间为 log2i + 1,需要取 n - 1 次，
 * 所以时间复杂度为 O(nlogn)
 * <p>
 * 堆排序对原始记录的排序并不敏感，无论最后最坏都是 nlogn.
 * 堆排序对元素的比较和交换都是跳跃式的，因此该排序不稳定。
 * </p>
 *
 * @author: ytuan
 * @Date 2019-08-30 11:04
 */
public class HeapSorted {

    public static void main(String[] args) {

        HeapSorted heapSorted = new HeapSorted();

        int arr[] = new int[]{0, 9, 1, 5, 8, 3, 7, 4, 6, 2};

        heapSorted.heapSorted(arr);
    }

    /**
     * @param arr
     */
    public void heapSorted(int[] arr) {

        int i;

        int len = arr.length;

        /**
         * (len - 1) / 2 是完全二叉树的第一个非叶子节点
         */

        // 将待排序的数组调整为一个最大堆
        for (i = (len - 1) / 2; i >= 0; i--) {
            heapAdjust(arr, i, len - 1);
        }

        for (i = len - 1; i > 0; i--) {
            //  将堆的最大值，也就是根节点和当前为排序序列的最后一个元素交换位置
            ArrayUtils.swap(arr, 0, i);
            // 将剩下的序列继续调整一个最大堆
            heapAdjust(arr, 0, i - 1);

            ArrayUtils.printArray(arr);
            System.out.println();
        }
    }

    /**
     * 将数组中指定起始和结束之间的元素调整为最大堆,[pos, end] 闭区间
     *
     * @param arr
     * @param pos 起始位置
     * @param end 结束位置
     */
    private void heapAdjust(int[] arr, int pos, int end) {

        // 循环条件是 该节点存在孩子节点
        while (pos * 2 + 1 <= end) {

            int j = pos * 2 + 1;

            if (j + 1 <= end && arr[j + 1] > arr[j]) {
                j++;
            }

            if (arr[j] > arr[pos]) {
                ArrayUtils.swap(arr, pos, j);
                pos = j;
            } else {
                break;
            }
        }
    }
}
