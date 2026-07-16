/*
---------------------------------------------------------
Problem: Climbing Stairs

Platform: LeetCode

Difficulty: Easy

Approach:
Dynamic Programming (Space Optimized)

Algorithm:
1. Handle the base cases:
   - If n <= 2, return n.
2. Initialize:
   - twoStepsBack = 1
   - oneStepBack = 2
3. Iterate from step 3 to n:
   - Compute the current number of ways as the sum of
     the previous two values.
   - Update the previous values.
4. Return the number of ways to reach the nth step.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/climbing-stairs/
---------------------------------------------------------
*/

class Solution {

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int twoStepsBack = 1;
        int oneStepBack = 2;
        int currentWays = 0;

        for (int i = 3; i <= n; i++) {

            currentWays = oneStepBack + twoStepsBack;
            twoStepsBack = oneStepBack;
            oneStepBack = currentWays;
        }

        return oneStepBack;
    }
}