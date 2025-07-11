package Leetcode;

import java.util.HashMap;

// memoization
class q509 {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n <= 1) return n;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int res = fib(n-1) + fib(n-2);
        memo.put(n, res);

        return res;
    }
}

// tabulation
class q509 {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        for (int i=0; i<=n; i++) {
            if (i <= 1) memo.put(i, i);
            else memo.put(i, memo.get(i-1) + memo.get(i-2));
        }

        return memo.get(n);
    }
}

// space optimization
class q509 {
    public int fib(int n) {
        if (n <= 1) return n;

        int prev2 = 0, prev = 1, curr = prev + prev2;

        for (int i=2; i<=n; i++) {
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }

        return curr;
    }
}

//509. Fibonacci Number
//Solved
//        Easy
//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
//        Given n, calculate F(n).
//
//
//
//Example 1:
//
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//Example 2:
//
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//Example 3:
//
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.