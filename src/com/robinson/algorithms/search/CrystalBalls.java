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

}
