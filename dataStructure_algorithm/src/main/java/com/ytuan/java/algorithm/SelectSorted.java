package com.ytuan.java.algorithm;

public class SelectSorted {

    public void selectSorted(int arr[]) {

        if (arr == null || arr.length == 0)
            return;

        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[j] > arr[i])
                    ArrayUtils.swap(arr, i, j);
            }
        }
    }

    public static void main(String[] args) {

        SelectSorted selectSorted = new SelectSorted();

        int arr[] = new int[]{6, 4, 8, 7, 5};
        selectSorted.selectSorted(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
