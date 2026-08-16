/*
---------------------------------------------------------
Problem: Non-decreasing Array

Platform: LeetCode

Difficulty: Medium

Approach:
Greedy

Algorithm:
1. Traverse the array and look for a violation where:
   nums[i] > nums[i + 1].

2. A non-decreasing array can contain at most one such
   violation.

3. When the first violation is found:
   - If nums[i - 1] > nums[i + 1], increase nums[i + 1]
     to nums[i].
   - Otherwise, decrease nums[i] to nums[i + 1].

4. If a second violation is found, return false.

5. If the entire array is traversed with at most one
   modification, return true.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/non-decreasing-array/
---------------------------------------------------------
*/

class Solution {

    public boolean checkPossibility(int[] nums) {

        boolean violation = false;

        for (int i = 0; i < nums.length - 1; i++) {

            // Check for decreasing pair
            if (nums[i] > nums[i + 1]) {

                // More than one violation
                if (violation) {
                    return false;
                }

                violation = true;

                /*
                 * Decide which element to modify:
                 * If nums[i - 1] > nums[i + 1], modify nums[i + 1].
                 * Otherwise, modify nums[i].
                 */
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }

        return true;
    }
}