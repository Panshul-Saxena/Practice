//•canSum(targetSum, numbers)'
//Write a function that takes in a targetSum and an array of numbers as arguments.
//The function should return a boolean indicating whether or not it is possible to generate the targetSum using numbers from the array.

//You may use an element of the array as many times as needed.
//You may assume that all input numbers are non-negative.

package dataStructuresAndAlgorithms.dynamicProgramming;
import java.util.HashMap;

public class canSumProb {

//    public static boolean canSum(int[] arr, int target) {
//        if (target == 0) return true;
//        if (target < 0) return false;
//
//        for (int num:arr) {
//            if (canSum(arr, target - num)) return true;
//        }
//
//        return false;
//    }

    private static boolean canSum(int[] arr, int target, HashMap<Integer, Boolean> memo) {
        if (target == 0) return true;
        if (target < 0) return false;

        if (memo.containsKey(target)) return memo.get(target);

        for (int num : arr) {
            int remainder = target - num;
            if (canSum(arr, remainder, memo)) {
                memo.put(target, true);
                return true;
            }
        }

        memo.put(target, false);
        return false;
    }

    public static boolean canSum(int[] arr, int target) {
        HashMap<Integer, Boolean> memo = new HashMap<>();

        return canSum(arr, target, memo);
    }


    public static void main(String[] args) {
        System.out.println(canSum(new int[]{1, 2, 3, 4, 5}, 5));    // true
        System.out.println(canSum(new int[]{5, 3, 4, 7}, 7));       // true
        System.out.println(canSum(new int[]{2, 3}, 7));             // true
        System.out.println(canSum(new int[]{2, 4}, 7));             // false
        System.out.println(canSum(new int[]{7, 14}, 300));          // false

    }
}

//        long start = System.nanoTime();
//          // Code Block
//        long end = System.nanoTime();
//        long timeElapsed = (end - start) / 1_000_000; // convert to milliseconds
//        System.out.println("Execution time in milliseconds: " + timeElapsed);
