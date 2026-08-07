/*
---------------------------------------------------------
Problem: Cells with Odd Values in a Matrix

Platform: LeetCode

Difficulty: Easy

Approach:
Counting

Algorithm:
1. Create two arrays:
   - rowCnt to count increments for each row.
   - colCnt to count increments for each column.
2. Traverse the `indices` array:
   - Increment the corresponding row count.
   - Increment the corresponding column count.
3. Count:
   - oddRows = rows with an odd number of increments.
   - evenRows = m - oddRows.
   - oddCols = columns with an odd number of increments.
   - evenCols = n - oddCols.
4. A cell is odd if:
   - Its row is odd and its column is even, or
   - Its row is even and its column is odd.
5. Return:
      (oddRows × evenCols) + (evenRows × oddCols)

Time Complexity:
O(m + n + indices.length)

Space Complexity:
O(m + n)

Link:
https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
---------------------------------------------------------
*/

class Solution {

    public int oddCells(int m, int n, int[][] indices) {

        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];

        for (int[] index : indices) {
            rowCnt[index[0]]++;
            colCnt[index[1]]++;
        }

        int oddRows = 0;
        for (int count : rowCnt) {
            if (count % 2 != 0) {
                oddRows++;
            }
        }

        int evenRows = m - oddRows;

        int oddCols = 0;
        for (int count : colCnt) {
            if (count % 2 != 0) {
                oddCols++;
            }
        }

        int evenCols = n - oddCols;

        return (oddRows * evenCols) + (evenRows * oddCols);
    }
}