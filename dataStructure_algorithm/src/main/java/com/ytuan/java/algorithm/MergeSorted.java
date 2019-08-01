package com.ytuan.java.algorithm;

public class MergeSorted {

    public void mergeSorted(int arr[]) {

        if (arr == null || arr.length == 0)
            return;

        int len = arr.length;

        split(arr, 0, arr.length - 1);

    }

    private void split(int arr[], int start, int end) {

        if (start >= end)
            return;

        int mid = (end + start) / 2;

        split(arr, start, mid);
        split(arr, mid + 1, end);

        if (arr[mid] > arr[mid + 1])
            merge(arr, start, mid, end);

        System.out.print("经过一次排序处理：");
        ArrayUtils.printArray(arr);
        System.out.println();
        System.out.println("start = " + start + "\t" + "end = " + end);
    }

    private void merge(int[] arr, int start, int mid, int end) {

        int aux[] = new int[(end - start) + 1];

        for (int i = start; i <= end; i++)
            aux[i - start] = arr[i];

        int i = start;
        int j = mid + 1;

        for (int k = start; k <= end; k++) {

            if (i > mid) {
                arr[k] = aux[j - start];
                j++;
            } else if (j > end) {
                arr[k] = aux[i - start];
                i++;
            } else if (aux[i - start] > aux[j - start]) {
                arr[k] = aux[j - start];
                j++;
            } else if (aux[i - start] < aux[j - start]) {
                arr[k] = aux[i - start];
                i++;
            } else {  // 相等的情况
                arr[k] = aux[i - start];
                i++;
            }
        }
    }

    public static void main(String[] args) {

        MergeSorted mergeSorted = new MergeSorted();

        // 30, 29,28,27,26,25,24,23,22,21,20, 19, 18, 17, 16,15, 14, 13, 12, 11, 10, 9, 8, 7, 6,

        int arr[] = new int[]{5, 4, 3, 2, 1};

        System.out.print(" ========>原始：");

        ArrayUtils.printArray(arr);

        System.out.println();

        mergeSorted.mergeSorted(arr);

    }
}
