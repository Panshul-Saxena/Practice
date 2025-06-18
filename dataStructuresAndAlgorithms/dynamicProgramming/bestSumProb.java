package dataStructuresAndAlgorithms.dynamicProgramming;
//Write a function bestSum( targetSum, numbers) that takes in a targetSum and an array of numbers as arguments.
//The function should return an array containing the shortest combination of numbers that add up to exactly the targetSum.
//If there is a tie for the shortest combination, you may return any one of the shortest.

public class bestSumProb {
    public static int[] bestSum(int[] arr, int target) {
        if (target == 0) return new int[0];
        if (target < 0) return null;

        for (int num:arr) {
            int remainder = target - num;
            int[] remainderResult = bestSum(arr, remainder);
            if (remainderResult != null) {
                int[] result = new int[remainderResult.length + 1];
                System.arraycopy(remainderResult, 0, result, 0, remainderResult.length);
                result[remainderResult.length] = num;
                return result;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
