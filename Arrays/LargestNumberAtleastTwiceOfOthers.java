/*
---------------------------------------------------------
Problem: Largest Number At Least Twice of Others

Platform: LeetCode

Difficulty: Easy

Approach:
Array Traversal

Algorithm:
1. Find the index of the largest element in the array.

2. Traverse the array again and compare the largest element
   with every other element.

3. The largest element must be at least twice every other
   element.

4. If any element violates this condition, return -1.

5. Otherwise, return the index of the largest element.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/largest-number-at-least-twice-of-others/
---------------------------------------------------------
*/

class Solution {

    public int dominantIndex(int[] nums) {

        int maxIdx = 0;

        // Find the index of the largest element
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        // Check if the largest element is at least
        // twice every other element
        for (int i = 0; i < nums.length; i++) {

            if (i != maxIdx && nums[maxIdx] < 2 * nums[i]) {
                return -1;
            }
        }

        return maxIdx;
    }
}