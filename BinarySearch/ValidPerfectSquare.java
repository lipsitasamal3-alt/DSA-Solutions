/*
---------------------------------------------------------
Problem: Valid Perfect Square

Platform: LeetCode

Difficulty: Easy

Approach:
Binary Search

Algorithm:
1. Initialize the search range:
   - left = 1
   - right = num
2. While left is less than or equal to right:
   - Compute the middle value.
   - Calculate its square.
   - If the square equals the given number, return true.
   - If the square is smaller, search the right half.
   - Otherwise, search the left half.
3. If no perfect square is found, return false.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/valid-perfect-square/
---------------------------------------------------------
*/

class Solution {

    public boolean isPerfectSquare(int num) {

        long left = 1;
        long right = num;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}