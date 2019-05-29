package com.ytuan.java.algorithm;

public class InsertSorted {

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

    public void insertSorted2(int arr[]) {

        if (arr == null || arr.length == 0)
            return;

        int len = arr.length;

        for (int i = 1; i < len; i++) {

            int ele = arr[i];
            int j = -1;

            for (j = i; j > 0 && arr[j - 1] > ele; j--)
                arr[j] = arr[j - 1];
            arr[j] = ele;
        }
    }

    public static void main(String[] args) {

        InsertSorted insertSorted = new InsertSorted();

        int arr[] = new int[]{3, 8, 6, 12, 9, 4, 7};

        insertSorted.insertSorted2(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
