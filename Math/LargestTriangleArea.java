/*
---------------------------------------------------------
Problem: Largest Triangle Area

Platform: LeetCode

Difficulty: Easy

Approach:
Brute Force + Geometry

Algorithm:
1. Initialize the maximum area as 0.
2. Iterate through every combination of three distinct points.
3. For each triplet:
   - Compute the triangle's area using the Shoelace Formula:
       Area = |x1(y2−y3) + x2(y3−y1) + x3(y1−y2)| / 2
   - Update the maximum area if the current area is larger.
4. Return the maximum area found.

Time Complexity:
O(n³)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/largest-triangle-area/
---------------------------------------------------------
*/

class Solution {

    public double largestTriangleArea(int[][] points) {

        double maxArea = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {

            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {

                int x2 = points[j][0];
                int y2 = points[j][1];

                for (int k = j + 1; k < n; k++) {

                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    double currentArea = 0.5 * Math.abs(
                        x1 * (y2 - y3)
                      + x2 * (y3 - y1)
                      + x3 * (y1 - y2)
                    );

                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }
}