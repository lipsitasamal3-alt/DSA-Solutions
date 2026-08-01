/*
---------------------------------------------------------
Problem: Arranging Coins

Platform: LeetCode

Difficulty: Easy

Approach:
Binary Search

Algorithm:
1. Set the search range:
   - left = 0
   - right = n
2. While left is less than or equal to right:
   - Compute the middle value.
   - Calculate the number of coins needed to build
     `mid` complete rows using:
       mid × (mid + 1) / 2
   - If the required coins equal n, return mid.
   - If fewer coins are required, search the right half.
   - Otherwise, search the left half.
3. When the loop ends, `right` represents the maximum
   number of complete rows that can be formed.
4. Return `right`.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/arranging-coins/
---------------------------------------------------------
*/

class Solution {

    public int arrangeCoins(int n) {

        long left = 0;
        long right = n;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long coinsUsed = mid * (mid + 1) / 2;

            if (coinsUsed == n) {
                return (int) mid;
            } else if (coinsUsed < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
}