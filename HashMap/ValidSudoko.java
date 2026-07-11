/*
---------------------------------------------------------
Problem: Valid Sudoku

Platform: LeetCode

Difficulty: Medium

Approach:
HashSet

Algorithm:
1. Create a HashSet to store the occurrence of numbers.
2. Traverse each cell of the Sudoku board.
3. Ignore empty cells ('.').
4. For each number:
   - Check if it already exists in the current row.
   - Check if it already exists in the current column.
   - Check if it already exists in the corresponding 3×3 sub-box.
5. If any duplicate is found, return false.
6. If the entire board is traversed without duplicates,
   return true.

Time Complexity:
O(81) ≈ O(1)

Space Complexity:
O(81) ≈ O(1)

Link:
https://leetcode.com/problems/valid-sudoku/
---------------------------------------------------------
*/

class Solution {

    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char number = board[i][j];

                if (number != '.') {

                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in col " + j) ||
                        !seen.add(number + " in box " + (i / 3) + "-" + (j / 3))) {

                        return false;
                    }
                }
            }
        }

        return true;
    }
}