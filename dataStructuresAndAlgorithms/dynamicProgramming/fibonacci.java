package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class fibonacci {
    static int fibonacci(int n) {
        if (n == 2 || n == 1) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static Map<Integer, Integer> memo = new HashMap<>();

    static int fibonacciMemoized(int n) {
        if (n == 1 || n == 2) return n;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {

    }
}
