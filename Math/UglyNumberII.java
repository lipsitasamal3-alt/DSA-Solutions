/*
---------------------------------------------------------
Problem: Ugly Number II

Platform: LeetCode

Difficulty: Medium

Approach:
Dynamic Programming

Algorithm:
1. Create a DP array where dp[i] stores the (i + 1)-th ugly number.
2. Initialize dp[0] = 1.
3. Maintain three pointers:
   - i2 for multiples of 2
   - i3 for multiples of 3
   - i5 for multiples of 5
4. For each position:
   - Compute the next multiples of 2, 3, and 5.
   - Choose the smallest as the next ugly number.
   - Store it in the DP array.
   - Increment every pointer whose multiple matches the chosen
     ugly number to avoid duplicates.
5. Return the last value in the DP array.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/ugly-number-ii/
---------------------------------------------------------
*/

class Solution {

    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i = 1; i < n; i++) {

            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;

            int nextUgly = Math.min(next2, Math.min(next3, next5));

            dp[i] = nextUgly;

            if (nextUgly == next2) {
                i2++;
            }

            if (nextUgly == next3) {
                i3++;
            }

            if (nextUgly == next5) {
                i5++;
            }
        }

        return dp[n - 1];
    }
}