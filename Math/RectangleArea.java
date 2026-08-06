/*
---------------------------------------------------------
Problem: Rectangle Area

Platform: LeetCode

Difficulty: Medium

Approach:
Math + Geometry

Algorithm:
1. Compute the area of the first rectangle.
2. Compute the area of the second rectangle.
3. Find the overlapping width:
   - left = max(ax1, bx1)
   - right = min(ax2, bx2)
4. Find the overlapping height:
   - bottom = max(ay1, by1)
   - top = min(ay2, by2)
5. If the rectangles overlap:
   - overlapArea = overlapWidth × overlapHeight
6. Return:
   areaA + areaB − overlapArea

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/rectangle-area/
---------------------------------------------------------
*/

class Solution {

    public int computeArea(
            int ax1, int ay1, int ax2, int ay2,
            int bx1, int by1, int bx2, int by2) {

        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        int overlapWidth =
                Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));

        int overlapHeight =
                Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        int overlapArea = overlapWidth * overlapHeight;

        return areaA + areaB - overlapArea;
    }
}