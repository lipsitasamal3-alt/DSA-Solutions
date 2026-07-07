/*
---------------------------------------------------------
Problem: Search in Rotated Sorted Array

Platform: LeetCode

Difficulty: Medium

Approach:
Modified Binary Search

Algorithm:
1. Initialize two pointers: left and right.
2. Find the middle element.
3. If the middle element is the target, return its index.
4. Check which half of the array is sorted.
5. Determine if the target lies in the sorted half.
6. Continue searching in the appropriate half.
7. Return -1 if the target is not found.

Time Complexity: O(log n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/search-in-rotated-sorted-array/
---------------------------------------------------------
*/

class Solution {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}