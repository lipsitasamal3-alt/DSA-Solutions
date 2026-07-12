/*
---------------------------------------------------------
Problem: Trapping Rain Water

Platform: LeetCode

Difficulty: Hard

Approach:
Two Pointers

Algorithm:
1. Handle the edge case where the array is empty.
2. Initialize two pointers:
   - left at the beginning.
   - right at the end.
3. Maintain the maximum height seen from both sides.
4. While left is less than right:
   - If the left height is smaller:
     - Update leftMax if needed.
     - Otherwise, add trapped water.
     - Move the left pointer.
   - Otherwise:
     - Update rightMax if needed.
     - Otherwise, add trapped water.
     - Move the right pointer.
5. Return the total trapped water.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/trapping-rain-water/
---------------------------------------------------------
*/

class Solution {

    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }
}