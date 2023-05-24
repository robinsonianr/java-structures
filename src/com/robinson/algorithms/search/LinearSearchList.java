package com.robinson.algorithms.search;

public class LinearSearchList {
    public static boolean linearSearch(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }


}
