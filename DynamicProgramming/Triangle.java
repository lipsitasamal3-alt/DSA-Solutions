/*
---------------------------------------------------------
Problem: Triangle

Platform: LeetCode

Difficulty: Medium

Approach:
Dynamic Programming + Bottom-Up

Algorithm:
1. Start from the second-last row of the triangle and move
   upward.

2. For every element in the current row, look at its two
   possible children in the row below.

3. Choose the smaller of the two children.

4. Add this minimum child value to the current element.
   This transforms the current element into the minimum
   path sum from that position to the bottom.

5. Continue until reaching the first row.

6. The top element then contains the minimum path sum from
   the top to the bottom of the triangle.

7. The triangle itself is modified to store the DP values,
   so no extra DP array is required.

Time Complexity:
O(n²)

Space Complexity:
O(1)
(Excluding the input triangle.)

Link:
https://leetcode.com/problems/triangle/
---------------------------------------------------------
*/

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        // Start from the second-last row and move upward
        for (int i = triangle.size() - 2; i >= 0; i--) {

            // Traverse every element in the current row
            for (int j = 0; j <= i; j++) {

                // Find the smaller of the two possible children
                int minChild = Math.min(
                    triangle.get(i + 1).get(j),
                    triangle.get(i + 1).get(j + 1)
                );

                // Update current position with minimum path sum
                triangle.get(i).set(
                    j,
                    triangle.get(i).get(j) + minChild
                );
            }
        }

        // Top element contains the minimum path sum
        return triangle.get(0).get(0);
    }
}