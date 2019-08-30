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

        pivot = arr[low];

        while (low < high) {

            while (low < high && arr[high] > pivot) {
                high--;
            }
            ArrayUtils.swap(arr, low, high);

            while (low < high && arr[low] < pivot) {
                low++;
            }
            ArrayUtils.swap(arr, low, high);
        }

        return low;
    }
}
