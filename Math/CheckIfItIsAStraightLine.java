/*
---------------------------------------------------------
Problem: Check If It Is a Straight Line

Platform: LeetCode

Difficulty: Easy

Approach:
Math + Geometry

Algorithm:
1. Take the first two points and compute:
   - dx = x1 - x0
   - dy = y1 - y0
2. For every remaining point:
   - Check whether it satisfies the same slope using
     cross multiplication:
       dy × (xi - x0) == dx × (yi - y0)
3. If any point violates the condition, return false.
4. If all points satisfy it, return true.

Note:
Cross multiplication avoids division and correctly handles
vertical lines.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/check-if-it-is-a-straight-line/
---------------------------------------------------------
*/

class Solution {

    public boolean checkStraightLine(int[][] coordinates) {

        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];

        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        for (int i = 2; i < coordinates.length; i++) {

            int xi = coordinates[i][0];
            int yi = coordinates[i][1];

            if (dy * (xi - x0) != dx * (yi - y0)) {
                return false;
            }
        }

        return true;
    }
}