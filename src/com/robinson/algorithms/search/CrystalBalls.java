package com.robinson.algorithms.search;

public class CrystalBalls {


    public static int twoCrystalBalls(boolean[] breaks) {
        int jumpAmount = (int) Math.floor(Math.sqrt(breaks.length));
        int i = jumpAmount;
        for (; i < breaks.length; i += jumpAmount) {
            if (breaks[i]) {
                break;
            }
        }
        i -= jumpAmount;

        for (int j = 0; j < jumpAmount && j < breaks.length; j++, i++) {
            if (breaks[j]) {
                return i;
            }
        }
        return -1;
    }



    private int binarySearch2(int[] haystack, int needle) {
        int lo = 0;
        int hi = haystack.length;

        while (lo < hi) {
            int mid = (lo + (hi + lo) / 2);
            int midVal = haystack[mid];

            if (midVal == needle) {
                return mid;
            } else if(midVal > needle){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

}
