/*
---------------------------------------------------------
Problem: Find Minimum in Rotated Sorted Array

Platform: LeetCode

Difficulty: Medium

Approach:
Binary Search

Algorithm:
1. Initialize two pointers:
   - left = 0
   - right = last index
2. While left is less than right:
   - Find the middle index.
   - If nums[mid] is greater than nums[right],
     the minimum lies in the right half.
     Move left = mid + 1.
   - Otherwise, the minimum is in the left half
     (including mid).
     Move right = mid.
3. When the loop ends, left points to the minimum element.
4. Return nums[left].

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
---------------------------------------------------------
*/

class Solution {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}