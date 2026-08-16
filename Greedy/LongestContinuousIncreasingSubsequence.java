/*
---------------------------------------------------------
Problem: Longest Continuous Increasing Subsequence

Platform: LeetCode

Difficulty: Easy

Approach:
Greedy + Array Traversal

Algorithm:
1. If the array is null or empty, return 0.

2. Maintain two variables:
   - `currentLen` = length of the current increasing
     continuous subsequence.
   - `maxLen` = maximum length found so far.

3. Traverse the array from the second element.

4. If nums[i] > nums[i - 1], the increasing subsequence
   continues, so increment `currentLen`.

5. Otherwise, the increasing subsequence is broken.
   Reset `currentLen` to 1.

6. Update `maxLen` after every element.

7. Return `maxLen`.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/longest-continuous-increasing-subsequence/
---------------------------------------------------------
*/

class Solution {

    public int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int currentLen = 1;

        // Traverse the array
        for (int i = 1; i < nums.length; i++) {

            // Continue the increasing subsequence
            if (nums[i] > nums[i - 1]) {
                currentLen++;
            } else {
                // Increasing sequence is broken
                currentLen = 1;
            }

            // Update maximum length
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}