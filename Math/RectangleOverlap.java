/*
---------------------------------------------------------
Problem: Rectangle Overlap

Platform: LeetCode

Difficulty: Easy

Approach:
Math + Geometry

Algorithm:
1. Extract the coordinates of both rectangles.
2. Two rectangles do NOT overlap if:
   - The first is completely to the left of the second.
   - The second is completely to the left of the first.
   - The first is completely below the second.
   - The second is completely below the first.
3. If none of the above conditions are true, the rectangles
   overlap.
4. Return the result.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/rectangle-overlap/
---------------------------------------------------------
*/

class Solution {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];

        return !(
                x2 <= x3 ||   // rec1 is left of rec2
                x4 <= x1 ||   // rec2 is left of rec1
                y2 <= y3 ||   // rec1 is below rec2
                y4 <= y1      // rec2 is below rec1
        );
    }
}