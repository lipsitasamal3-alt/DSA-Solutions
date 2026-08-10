/*
---------------------------------------------------------
Problem: Max Consecutive Ones

Platform: LeetCode

Difficulty: Easy

Approach:
Arrays + Counting

Algorithm:
1. Keep `currentCount` for the current consecutive sequence
   of 1s.
2. When the current element is 1:
   - Increment `currentCount`.
   - Update `maxCount`.
3. When the current element is 0:
   - Reset `currentCount` to 0.
4. Return the maximum streak found.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/max-consecutive-ones/
---------------------------------------------------------
*/

class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {

            if (num == 1) {

                currentCount++;

                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }

            } else {

                currentCount = 0;
            }
        }

        return maxCount;
    }
}