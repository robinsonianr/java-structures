package com.robinson.algorithms.search;

public class BinarySearchList {


    public static boolean binarySearch(int[] haystack, int needle) {
        int lo = 0;
        int hi = haystack.length;

        while (lo < hi) {
            int mid = (lo + (hi + lo) / 2);
            int midVal = haystack[mid];

            if (midVal == needle) {
                return true;
            } else if (needle > midVal) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return false;
    }
}
