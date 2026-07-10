/*
---------------------------------------------------------
Problem: First Missing Positive

Platform: LeetCode

Difficulty: Hard

Approach:
Cyclic Sort (Index Placement)

Algorithm:
1. Traverse the array.
2. While the current number is positive, within the array bounds,
   and not already in its correct position:
   - Swap it with the element at its correct index.
3. Traverse the array again.
4. The first index where nums[i] != i + 1 is the smallest
   missing positive integer.
5. If all numbers are in their correct positions,
   return n + 1.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/first-missing-positive/
---------------------------------------------------------
*/

class Solution {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            while (nums[i] > 0 &&
                   nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                int correctIdx = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }

        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}