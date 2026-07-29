/*
---------------------------------------------------------
Problem: Spiral Matrix IV

Platform: LeetCode

Difficulty: Medium

Approach:
Simulation

Algorithm:
1. Create an m × n matrix and initialize every cell with -1.
2. Maintain four boundaries:
   - top
   - bottom
   - left
   - right
3. Traverse the linked list while filling the matrix in spiral order:
   - Fill the top row from left to right.
   - Move the top boundary down.
   - Fill the right column from top to bottom.
   - Move the right boundary left.
   - Fill the bottom row from right to left.
   - Move the bottom boundary up.
   - Fill the left column from bottom to top.
   - Move the left boundary right.
4. Stop when the linked list is exhausted.
5. Return the filled matrix.

Time Complexity:
O(m × n)

Space Complexity:
O(m × n)

Link:
https://leetcode.com/problems/spiral-matrix-iv/
---------------------------------------------------------
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            java.util.Arrays.fill(matrix[i], -1);
        }

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        ListNode current = head;

        while (current != null) {

            for (int col = left; col <= right && current != null; col++) {
                matrix[top][col] = current.val;
                current = current.next;
            }
            top++;

            for (int row = top; row <= bottom && current != null; row++) {
                matrix[row][right] = current.val;
                current = current.next;
            }
            right--;

            for (int col = right; col >= left && current != null; col--) {
                matrix[bottom][col] = current.val;
                current = current.next;
            }
            bottom--;

            for (int row = bottom; row >= top && current != null; row--) {
                matrix[row][left] = current.val;
                current = current.next;
            }
            left++;
        }

        return matrix;
    }
}