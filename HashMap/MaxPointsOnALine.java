/*
---------------------------------------------------------
Problem: Max Points on a Line

Platform: LeetCode

Difficulty: Hard

Approach:
HashMap + Slope Normalization + GCD

Algorithm:
1. Consider each point as a fixed starting point.

2. For every other point, calculate the slope between the
   two points using:
   dy = y2 - y1
   dx = x2 - x1

3. Use GCD to reduce `dx` and `dy` to their simplest form.
   This ensures that the same slope is represented by the
   same pair of values.

4. Normalize the signs:
   - If `dx` is negative, make both `dx` and `dy` positive/
     consistently signed.
   - For vertical lines where `dx == 0`, make `dy` positive.

5. Store the normalized slope as a String key in a HashMap.
   The value represents how many points share that slope
   with the current starting point.

6. Track the maximum number of points having the same slope.

7. Add 1 for the starting point and update the global
   maximum.

8. Return the maximum number of points found on the same line.

Time Complexity:
O(n² log M)
where M is the coordinate difference, due to the GCD operation.

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/max-points-on-a-line/
---------------------------------------------------------
*/

class Solution {

    public int maxPoints(int[][] points) {

        int n = points.length;

        // If there are at most two points, all of them
        // are automatically on the same line.
        if (n <= 2) {
            return n;
        }

        int maxPointsOnLine = 0;

        // Consider every point as the starting point
        for (int i = 0; i < n; i++) {

            Map<String, Integer> slopeCount = new HashMap<>();

            int currentMax = 0;

            int x1 = points[i][0];
            int y1 = points[i][1];

            // Compare the current point with every
            // point after it
            for (int j = i + 1; j < n; j++) {

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x2 - x1;
                int dy = y2 - y1;

                // Reduce slope using GCD
                int g = gcd(dx, dy);

                dx /= g;
                dy /= g;

                // Normalize the sign
                if (dx < 0) {

                    dx = -dx;
                    dy = -dy;

                } else if (dx == 0) {

                    // Normalize vertical lines
                    dy = Math.abs(dy);
                }

                // Create a unique key for the slope
                String slopeKey = dy + "/" + dx;

                // Count points having the same slope
                slopeCount.put(
                    slopeKey,
                    slopeCount.getOrDefault(slopeKey, 0) + 1
                );

                // Update maximum for this starting point
                currentMax = Math.max(
                    currentMax,
                    slopeCount.get(slopeKey)
                );
            }

            // Include the starting point
            maxPointsOnLine = Math.max(
                maxPointsOnLine,
                currentMax + 1
            );
        }

        return maxPointsOnLine;
    }

    // Calculate Greatest Common Divisor
    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}