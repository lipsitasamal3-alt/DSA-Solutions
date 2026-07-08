/*
---------------------------------------------------------
Problem: Find First and Last Position of Element in Sorted Array

Platform: LeetCode

Difficulty: Medium

Approach:
Binary Search

Algorithm:
1. Perform binary search to find the first occurrence of the target.
2. Perform another binary search to find the last occurrence.
3. Store both indices in the result array.
4. If the target is not found, return {-1, -1}.

Time Complexity: O(log n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
---------------------------------------------------------
*/

class Solution {

    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};

        result[0] = findBound(nums, target, true);
        result[1] = findBound(nums, target, false);

        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {

        int left = 0;
        int right = nums.length - 1;
        int bound = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                bound = mid;

                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }
}