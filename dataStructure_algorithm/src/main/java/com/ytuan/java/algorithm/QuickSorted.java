package com.ytuan.java.algorithm;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-08-30 16:36
 */
public class QuickSorted {

    public static void main(String[] args) {

        QuickSorted quickSorted = new QuickSorted();

        int arr[] = new int[]{6, 4, 8, 7, 5};
        quickSorted.quickSorted(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public void quickSorted(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }

        quickSorted(arr, 0, arr.length - 1);
    }

    private void quickSorted(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = parttion(arr, low, high);

        quickSorted(arr, low, mid - 1);
        quickSorted(arr, mid + 1, high);
    }

    private int parttion(int[] arr, int low, int high) {

        /*基准值的下标*/
        int pivot;

        /**
         *  优化1. 基准值的选择 选取一组随机数 或者 分别选取左，中，右三个数排序后取中值
         */

        // 中间值的下标
        int mid = low + (high - low) / 2;

        // 交换左、右两端，保证左端最小
        if (arr[low] > arr[high]) {
            ArrayUtils.swap(arr, low, high);
        }
        // 交换中，右两端数据，保证中间最小
        if (arr[mid] > arr[high]) {
            ArrayUtils.swap(arr, mid, high);
        }
        // 交换左，中两端数据，保证左端最小
        if (arr[mid] > arr[low]) {
            ArrayUtils.swap(arr, low, mid);
        }

        pivot = arr[low];

        // 优化2. 减少不必要的交换
        int ele = pivot;

        while (low < high) {

            while (low < high && arr[high] > pivot) {
                high--;
            }
            //ArrayUtils.swap(arr,low, high);
            arr[low] = arr[high];

            while (low < high && arr[low] < pivot) {
                low++;
            }
            //ArrayUtils.swap(arr,low, high);
            arr[high] = arr[low];
        }

        arr[low] = ele;

        return low;
    }
}
