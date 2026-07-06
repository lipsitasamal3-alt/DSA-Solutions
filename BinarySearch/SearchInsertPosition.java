/*
---------------------------------------------------------
Problem: Search Insert Position

Platform: LeetCode

Difficulty: Easy

Approach:
Binary Search

Algorithm:
1. Initialize two pointers: left and right.
2. Find the middle element.
3. If the target is found, return its index.
4. If the target is greater, search the right half.
5. Otherwise, search the left half.
6. If the target is not found, return the insertion position (left).

Time Complexity: O(log n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/search-insert-position/
---------------------------------------------------------
*/

class Solution {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}