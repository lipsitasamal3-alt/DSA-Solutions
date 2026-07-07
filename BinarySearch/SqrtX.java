/*
---------------------------------------------------------
Problem: Sqrt(x)

Platform: LeetCode

Difficulty: Easy

Approach:
Binary Search

Algorithm:
1. Handle the base case when x is less than 2.
2. Initialize the search range from 2 to x/2.
3. Find the middle element.
4. Compare mid² with x.
5. If equal, return mid.
6. If mid² is smaller, search the right half.
7. Otherwise, search the left half.
8. Return the largest integer whose square is less than or equal to x.

Time Complexity: O(log n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/sqrtx/
---------------------------------------------------------
*/

class Solution {

    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        long num;
        int left = 2;
        int right = x / 2;
        int mid;

        while (left <= right) {

            mid = left + (right - left) / 2;
            num = (long) mid * mid;

            if (num > x) {
                right = mid - 1;
            } else if (num < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}