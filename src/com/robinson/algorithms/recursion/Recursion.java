package com.robinson.algorithms.recursion;

public class Recursion {


    public static int foo(int n) {
        // base case
        if (n == 1) {
            return 1;
        }

        return n + foo(n - 1);
    }
}
