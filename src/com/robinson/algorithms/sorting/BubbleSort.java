package com.robinson.algorithms.sorting;

public class BubbleSort {


    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
               if (arr[j] > arr[j + 1]) {
                   swap(arr, j, j + 1);
               }
            }
        }
        return arr;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
