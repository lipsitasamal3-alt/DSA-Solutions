/*
---------------------------------------------------------
Problem: Container With Most Water

Platform: LeetCode

Difficulty: Medium

Approach:
Two Pointers

Algorithm:
1. Place one pointer at the beginning and one at the end of the array.
2. Calculate the area formed by the two lines.
3. Update the maximum area if the current area is larger.
4. Move the pointer pointing to the shorter line inward.
5. Repeat until both pointers meet.

Time Complexity: O(n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/container-with-most-water/
---------------------------------------------------------
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);

            maxArea = Math.max(maxArea, width * h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}