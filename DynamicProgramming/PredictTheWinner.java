/*
---------------------------------------------------------
Problem: Predict the Winner

Platform: LeetCode

Difficulty: Medium

Approach:
Dynamic Programming (Space Optimized)

Algorithm:
1. Let dp[i] represent the maximum score difference
   the current player can achieve over the opponent
   for the current subarray.
2. Initialize dp[i] with nums[i] for all indices.
3. Expand the subarray length from 2 to n.
4. For each subarray:
   - Choose the left number:
     nums[i] - dp[i + 1]
   - Choose the right number:
     nums[j] - dp[i]
   - Store the maximum of the two choices.
5. After processing all subarrays,
   dp[0] contains the maximum score difference.
6. If dp[0] is non-negative, Player 1 can win
   or tie; otherwise, Player 2 wins.

Time Complexity:
O(n²)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/predict-the-winner/
---------------------------------------------------------
*/

class Solution {

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                dp[i] = Math.max(
                        nums[i] - dp[i + 1],
                        nums[j] - dp[i]
                );
            }
        }

        return dp[0] >= 0;
    }
}