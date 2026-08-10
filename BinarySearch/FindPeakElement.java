/*
---------------------------------------------------------
Problem: Find Peak Element

Platform: LeetCode

Difficulty: Medium

Approach:
Binary Search

Algorithm:
1. Set `left` to the first index and `right` to the last index.
2. While `left < right`:
   - Calculate the middle index.
   - Compare `nums[mid]` with `nums[mid + 1]`.
3. If:
      nums[mid] > nums[mid + 1]
   then we are on a decreasing slope, so a peak exists at
   `mid` or somewhere to its left.
   Set:
      right = mid
4. Otherwise, we are on an increasing slope, so a peak exists
   to the right of `mid`.
   Set:
      left = mid + 1
5. When `left == right`, that index is a peak.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-peak-element/
---------------------------------------------------------
*/

class Solution {

    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}