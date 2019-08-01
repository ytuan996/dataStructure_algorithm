package com.ytuan.java.algorithm;

public class BubbleSorted {

    public void bubbleSorted(int arr[]) {
        if (arr == null || arr.length == 0)
            return;

        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    ArrayUtils.swap(arr, j, j + 1);
            }
            ArrayUtils.printArray(arr);

        }


    }

    public static void main(String[] args) {

        BubbleSorted bubbleSorted = new BubbleSorted();

        int arr[] = new int[]{6, 4, 8, 7, 5};
        bubbleSorted.bubbleSorted(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
