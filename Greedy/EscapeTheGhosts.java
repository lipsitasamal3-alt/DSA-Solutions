/*
---------------------------------------------------------
Problem: Escape The Ghosts

Platform: LeetCode

Difficulty: Medium

Approach:
Greedy + Manhattan Distance

Algorithm:
1. Calculate the Manhattan distance from the origin to
   the target:
   |target[0]| + |target[1]|

2. For every ghost, calculate its Manhattan distance from
   the ghost's position to the target.

3. If any ghost can reach the target in the same number of
   moves or fewer than us, escape is impossible.

4. Therefore, if:
   ghostDistance <= myDistance
   return false.

5. If no ghost can reach the target before or at the same
   time as us, return true.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/escape-the-ghosts/
---------------------------------------------------------
*/

class Solution {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {

        // Manhattan distance from our starting position
        // (0, 0) to the target
        int myDistance = Math.abs(target[0]) + Math.abs(target[1]);

        // Check every ghost
        for (int[] ghost : ghosts) {

            // Manhattan distance from ghost to target
            int ghostDistance =
                    Math.abs(ghost[0] - target[0])
                    + Math.abs(ghost[1] - target[1]);

            // Ghost can reach the target before or at the
            // same time as us
            if (ghostDistance <= myDistance) {
                return false;
            }
        }

        return true;
    }
}