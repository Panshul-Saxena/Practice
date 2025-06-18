package dataStructuresAndAlgorithms.dynamicProgramming;

//• howsum(targetsum, numbers)'
//Write a function that takes in a targetSum and an array of numbers as arguments.
//The function should return an array containing any combination of elements that add up to exactly the targetSum.
//If there is no combination that adds up to the targetSum, then return null.
//If there are multiple combinations possible, you may return any single one.

import java.util.HashMap;

public class howSumProb {

//    public static int[] howSum(int[] arr, int target) {
//        if (target == 0) return new int[0];
//        if (target < 0) return null;
//
//        for (int num:arr) {
//            int remainder = target - num;
//            int[] remainderResult = howSum(arr, remainder);
//            if (remainderResult != null) {
//                int[] result = new int[remainderResult.length + 1];
//                System.arraycopy(remainderResult, 0, result, 0, remainderResult.length);
//                result[remainderResult.length] = num;
//                return result;
//            }
//        }
//
//        return null;
//    }

    private static int[] howSum(int[] arr, int target, HashMap<Integer, int[]> memo) {
        if (target == 0) return new int[0];
        if (target < 0) return null;

        if (memo.containsKey(target)) return memo.get(target);

        for (int num:arr) {
            int remainder = target - num;
            int[] remainderResult = howSum(arr, remainder, memo);
            if (remainderResult != null) {
                int[] result = new int[remainderResult.length + 1];
                System.arraycopy(remainderResult, 0, result, 0, remainderResult.length);
                result[remainderResult.length] = num;
                memo.put(target, result);
                return memo.get(target);
            }
        }

        memo.put(target, null);
        return null;
    }

    public static int[] howSum(int[] arr, int target) {
        HashMap<Integer, int[]> memo = new HashMap<>();
        return howSum(arr, target, memo);
    }


    public static void main(String[] args) {
        int[] res1 = howSum(new int[]{5, 3, 4, 7}, 7);
        if (res1 != null)
        {for (int num: res1) {System.out.print(num + " ");} System.out.println();}
        else
            System.out.println("Null");

        int[] res2 = howSum(new int[]{2, 3}, 7);
        if (res2 != null)
        {for (int num: res2) {System.out.print(num + " ");} System.out.println();}
        else
            System.out.println("Null");

        int[] res3 = howSum(new int[]{2, 4}, 7);
        if (res3 != null)
        {for (int num: res3) {System.out.print(num + " ");} System.out.println();}
        else
            System.out.println("Null");

        int[] res4 = howSum(new int[]{7, 14}, 300);
        if (res4 != null)
        {for (int num: res4) {System.out.print(num + " ");} System.out.println();}
        else
            System.out.println("Null");
    }
}
