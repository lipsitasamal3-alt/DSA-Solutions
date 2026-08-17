/*
---------------------------------------------------------
Problem: Valid Tic-Tac-Toe State

Platform: LeetCode

Difficulty: Medium

Approach:
Simulation + Validation

Algorithm:
1. Count the number of `X` and `O` characters on the board.

2. Since X always plays first:
   - X must have either the same number of moves as O,
     or exactly one more move.
   - Otherwise, the board is invalid.

3. Check whether X has won and whether O has won.

4. If X has won:
   - X must have played one more move than O.
   - Otherwise, the state is invalid.

5. If O has won:
   - X and O must have played the same number of moves.
   - Otherwise, the state is invalid.

6. If all conditions are satisfied, return true.

7. The `checkWin()` method checks all rows, columns,
   and both diagonals for a winning combination.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/valid-tic-tac-toe-state/
---------------------------------------------------------
*/

class Solution {

    public boolean validTicTacToe(String[] board) {

        int xCount = 0;
        int oCount = 0;

        // Count X and O moves
        for (String row : board) {

            for (char c : row.toCharArray()) {

                if (c == 'X') {
                    xCount++;
                }

                if (c == 'O') {
                    oCount++;
                }
            }
        }

        // X always plays first
        if (xCount != oCount && xCount != oCount + 1) {
            return false;
        }

        boolean xWin = checkWin(board, 'X');
        boolean oWin = checkWin(board, 'O');

        // If X wins, X must have one extra move
        if (xWin && xCount != oCount + 1) {
            return false;
        }

        // If O wins, both players must have equal moves
        if (oWin && xCount != oCount) {
            return false;
        }

        return true;
    }

    private boolean checkWin(String[] board, char p) {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {

            // Check row
            if (board[i].charAt(0) == p
                    && board[i].charAt(1) == p
                    && board[i].charAt(2) == p) {
                return true;
            }

            // Check column
            if (board[0].charAt(i) == p
                    && board[1].charAt(i) == p
                    && board[2].charAt(i) == p) {
                return true;
            }
        }

        // Check main diagonal
        if (board[0].charAt(0) == p
                && board[1].charAt(1) == p
                && board[2].charAt(2) == p) {
            return true;
        }

        // Check opposite diagonal
        if (board[0].charAt(2) == p
                && board[1].charAt(1) == p
                && board[2].charAt(0) == p) {
            return true;
        }

        return false;
    }
}