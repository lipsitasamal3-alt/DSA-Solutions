/*
---------------------------------------------------------
Problem: Find the Winner of the Circular Game

Platform: LeetCode

Difficulty: Medium

Approach:
Math (Josephus Problem)

Algorithm:
1. Initialize the winner index as 0
   (0-based indexing).
2. Iterate from 2 to n:
   - Update the winner using the Josephus recurrence:
     winner = (winner + k) % i
3. Convert the final answer to 1-based indexing.
4. Return the winner.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-the-winner-of-the-circular-game/
---------------------------------------------------------
*/

class Solution {

    public int findTheWinner(int n, int k) {

        int winner = 0;

        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }

        return winner + 1;
    }
}