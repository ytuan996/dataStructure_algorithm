package com.ytuan.java.algorithm.sort;

/**
 *
 * @Author: ytuan
 * @Date: 2019-08-30  17:32
 */
public class ArrayUtils {

    public static void swap(int arr[], int p, int q) {
        if (p < 0 || p >= arr.length || q < 0 || q >= arr.length)
            throw new IllegalArgumentException("index is out of bound" + p + "or" + q);
        int aux = arr[p];
        arr[p] = arr[q];
        arr[q] = aux;
    }

    public static void printArray(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
