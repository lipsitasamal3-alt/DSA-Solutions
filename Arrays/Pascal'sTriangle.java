/*
---------------------------------------------------------
Problem: Pascal's Triangle

Platform: LeetCode

Difficulty: Easy

Approach:
ArrayList + Dynamic Programming

Algorithm:
1. Create an empty list to store all rows of Pascal's
   Triangle.

2. If `numRows <= 0`, return the empty list.

3. The first row always contains only `1`.

4. For every subsequent row:
   - Start the row with `1`.
   - Calculate each middle element by adding the two
     adjacent elements from the previous row.
   - End the row with `1`.

5. Add every newly generated row to the triangle.

6. Return the complete Pascal's Triangle.

Time Complexity:
O(n²)

Space Complexity:
O(n²)
(The output itself contains O(n²) elements.)

Link:
https://leetcode.com/problems/pascals-triangle/
---------------------------------------------------------
*/

class Solution {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        // Handle invalid input
        if (numRows <= 0) {
            return triangle;
        }

        // Create the first row
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        triangle.add(firstRow);

        // Generate remaining rows
        for (int i = 1; i < numRows; i++) {

            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();

            // First element of every row is 1
            currRow.add(1);

            // Calculate middle elements
            for (int j = 1; j < i; j++) {

                int sum = prevRow.get(j - 1) + prevRow.get(j);

                currRow.add(sum);
            }

            // Last element of every row is 1
            currRow.add(1);

            triangle.add(currRow);
        }

        return triangle;
    }
}