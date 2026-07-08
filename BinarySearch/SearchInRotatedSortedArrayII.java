/*
---------------------------------------------------------
Problem: Search in Rotated Sorted Array II

Platform: LeetCode

Difficulty: Medium

Approach:
Modified Binary Search

Algorithm:
1. Initialize two pointers: left and right.
2. Find the middle element.
3. If the middle element is the target, return true.
4. If duplicates prevent identifying the sorted half,
   shrink both ends.
5. Otherwise, determine which half is sorted.
6. Check if the target lies in the sorted half.
7. Continue searching until the target is found or the
   search space becomes empty.

Time Complexity:
Average: O(log n)
Worst Case: O(n) (due to duplicates)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
---------------------------------------------------------
*/

class Solution {

    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Cannot determine the sorted half because of duplicates
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }

            // Left half is sorted
            else if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}