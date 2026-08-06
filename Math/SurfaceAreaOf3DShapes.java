/*
---------------------------------------------------------
Problem: Surface Area of 3D Shapes

Platform: LeetCode

Difficulty: Easy

Approach:
Simulation + Geometry

Algorithm:
1. Initialize the total surface area as 0.
2. Traverse each cell in the grid.
3. For every cell with value `v > 0`:
   - Add the surface area of an isolated stack:
       4 × v + 2
     (four side faces and one top and one bottom face)
4. Remove overlapping faces:
   - If there is a stack above, subtract:
       2 × min(current, upper)
   - If there is a stack to the left, subtract:
       2 × min(current, left)
5. Return the total surface area.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/surface-area-of-3d-shapes/
---------------------------------------------------------
*/

class Solution {

    public int surfaceArea(int[][] grid) {

        int n = grid.length;
        int totalArea = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int height = grid[i][j];

                if (height > 0) {

                    // Surface area of an isolated stack
                    totalArea += 4 * height + 2;

                    // Remove shared faces with the upper stack
                    if (i > 0) {
                        totalArea -= 2 * Math.min(height, grid[i - 1][j]);
                    }

                    // Remove shared faces with the left stack
                    if (j > 0) {
                        totalArea -= 2 * Math.min(height, grid[i][j - 1]);
                    }
                }
            }
        }

        return totalArea;
    }
}