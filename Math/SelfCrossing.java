/*
---------------------------------------------------------
Problem: Self Crossing

Platform: LeetCode

Difficulty: Hard

Approach:
Math / Geometry

Algorithm:
1. If the path has fewer than 4 moves, it cannot self-cross.
2. Traverse the distance array starting from the 4th move.
3. Check the three possible self-crossing cases:
   - Case 1:
     The current line crosses the line three steps before.
   - Case 2:
     The current line overlaps the line four steps before.
   - Case 3:
     The current line crosses the line five steps before
     (spiral crossing).
4. If any case is satisfied, return true.
5. If no crossing is found after checking all moves,
   return false.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/self-crossing/
---------------------------------------------------------
*/

class Solution {

    public boolean isSelfCrossing(int[] distance) {

        int n = distance.length;

        if (n <= 3) {
            return false;
        }

        for (int i = 3; i < n; i++) {

            // Case 1: Current line crosses the line 3 steps before.
            if (distance[i] >= distance[i - 2] &&
                distance[i - 1] <= distance[i - 3]) {
                return true;
            }

            // Case 2: Current line overlaps the line 4 steps before.
            if (i >= 4) {

                if (distance[i - 1] == distance[i - 3] &&
                    distance[i] + distance[i - 4] >= distance[i - 2]) {
                    return true;
                }
            }

            // Case 3: Current line crosses the line 5 steps before.
            if (i >= 5) {

                if (distance[i - 1] <= distance[i - 3] &&
                    distance[i - 1] + distance[i - 5] >= distance[i - 3] &&
                    distance[i - 2] >= distance[i - 4] &&
                    distance[i] + distance[i - 4] >= distance[i - 2]) {
                    return true;
                }
            }
        }

        return false;
    }
}