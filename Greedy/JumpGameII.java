/*
---------------------------------------------------------
Problem: Jump Game II

Platform: LeetCode

Difficulty: Medium

Approach:
Greedy

Algorithm:
1. Initialize:
   - jumps = 0
   - currentEnd = 0
   - farthest = 0
2. Traverse the array (excluding the last element).
3. Update the farthest reachable index from the current range.
4. When the current index reaches currentEnd:
   - Increment the jump count.
   - Update currentEnd to farthest.
5. If currentEnd reaches or passes the last index,
   stop the traversal.
6. Return the minimum number of jumps.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/jump-game-ii/
---------------------------------------------------------
*/

class Solution {

    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {

                jumps++;
                currentEnd = farthest;

                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}