package Leetcode;

public class q198 {
    // dp memoization
    HashMap<Integer, Integer> map;

    private int dp(int[] nums, int index) {
        if (index == 0) return nums[index];
        if (index < 0) return 0;

        if (map.containsKey(index)) return map.get(index);

        int picked = nums[index] + dp(nums, index-2);
        int notPicked = dp(nums, index-1);

        map.put(index, Math.max(picked, notPicked));
        return map.get(index);
    }

    public int rob(int[] nums) {
        map = new HashMap<>();
        return dp(nums, nums.length-1);
    }

//    //dp tabulation
//
//    class Solution {
//        public int rob(int[] nums) {
//            int n = nums.length;
//            int[] dp = new int[n];
//
//            if (n == 1) return nums[0];
//            dp[0] = nums[0];
//
//            for (int i=1; i<n;i++) {
//                int picked = nums[i];
//                if (i>1) picked += dp[i-2];
//
//                int notPicked = dp[i-1];
//
//                dp[i] = Math.max(picked, notPicked);
//            }
//
//            return dp[n-1];
//        }
//    }
//
//    //dp tabulation with space optimization
//    class Solution {
//        public int rob(int[] nums) {
//            int n = nums.length;
//            if (n == 1)
//                return nums[0];
//
//            int prev2 = 0;
//            int prev = nums[0];
//
//            for (int i = 1; i < n; i++) {
//                int picked = nums[i] + prev2;
//                int notPicked = prev;
//
//                int curr = Math.max(picked, notPicked);
//
//                prev2 = prev;
//                prev = curr;
//            }
//
//            return prev;
//        }
//    }
}

//198. House Robber
//Solved
//        Medium
//Topics
//premium lock icon
//        Companies
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//
//
//        Example 1:
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//Example 2:
//
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//Constraints:
//
//        1 <= nums.length <= 100
//        0 <= nums[i] <= 400