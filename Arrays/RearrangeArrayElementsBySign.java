/*
---------------------------------------------------------
Problem: Rearrange Array Elements by Sign

Platform: LeetCode

Difficulty: Medium

Approach:
Array Traversal + Two Pointers

Algorithm:
1. Create a result array `ans` of the same size as `nums`.

2. Maintain two indices:
   - `posIndex` starts at 0 and points to the next position
     for a positive number.
   - `negIndex` starts at 1 and points to the next position
     for a negative number.

3. Traverse the input array.

4. If the current number is negative:
   - Place it at `negIndex`.
   - Move `negIndex` forward by 2.

5. Otherwise, place the positive number at `posIndex`
   and move `posIndex` forward by 2.

6. Return the rearranged array.

Time Complexity:
O(n)

Space Complexity:
O(n)
(The result array requires O(n) extra space.)

Link:
https://leetcode.com/problems/rearrange-array-elements-by-sign/
---------------------------------------------------------
*/

class Solution {

    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        // Index for positive numbers
        int posIndex = 0;

        // Index for negative numbers
        int negIndex = 1;

        // Traverse the input array
        for (int i = 0; i < n; i++) {

            if (nums[i] < 0) {

                // Place negative number at an odd index
                ans[negIndex] = nums[i];
                negIndex += 2;

            } else {

                // Place positive number at an even index
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }

        return ans;
    }
}