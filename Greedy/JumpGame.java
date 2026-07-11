/*
---------------------------------------------------------
Problem: Jump Game

Platform: LeetCode

Difficulty: Medium

Approach:
Greedy

Algorithm:
1. Initialize the target as the last index of the array.
2. Traverse the array from right to left.
3. For each index:
   - If the current index can reach or pass the target,
     update the target to the current index.
4. After the traversal, check whether the target has
   reached the first index.
5. If the target is 0, return true; otherwise, return false.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/jump-game/
---------------------------------------------------------
*/

class Solution {

    public boolean canJump(int[] nums) {

        int target = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (i + nums[i] >= target) {
                target = i;
            }
        }

        return target == 0;
    }
}