/*
---------------------------------------------------------
Problem: Best Time to Buy and Sell Stock

Platform: LeetCode

Difficulty: Easy

Approach:
Greedy + Array Traversal

Algorithm:
1. Maintain `min` to store the minimum stock price seen
   so far.

2. Traverse the array from the second day onward.

3. For each price, calculate the profit that would be
   obtained by buying at the minimum price seen so far
   and selling at the current price.

4. Update `maxProfit` with the maximum profit found.

5. Update `min` if the current price is lower than the
   previous minimum.

6. Return `maxProfit`.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
---------------------------------------------------------
*/

class Solution {

    public int maxProfit(int[] prices) {

        // Minimum price seen so far
        int min = prices[0];

        // Maximum profit found so far
        int maxProfit = 0;

        int n = prices.length;

        // Traverse the prices
        for (int i = 1; i < n; i++) {

            // Calculate profit if selling today
            int cost = prices[i] - min;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, cost);

            // Update minimum buying price
            min = Math.min(min, prices[i]);
        }

        return maxProfit;
    }
}