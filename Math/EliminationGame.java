/*
---------------------------------------------------------
Problem: Elimination Game

Platform: LeetCode

Difficulty: Medium

Approach:
Mathematical Simulation

Algorithm:
1. Initialize:
   - head = 1 (first remaining number)
   - step = 1 (distance between remaining numbers)
   - remaining = n
   - leftToRight = true
2. While more than one number remains:
   - Move the head if:
     - Eliminating from left to right, or
     - Eliminating from right to left with an odd
       number of remaining elements.
   - Halve the number of remaining elements.
   - Double the step size.
   - Reverse the elimination direction.
3. Return the remaining head.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/elimination-game/
---------------------------------------------------------
*/

class Solution {

    public int lastRemaining(int n) {

        int head = 1;
        int step = 1;
        int remaining = n;
        boolean leftToRight = true;

        while (remaining > 1) {

            if (leftToRight || remaining % 2 == 1) {
                head += step;
            }

            remaining /= 2;
            step *= 2;
            leftToRight = !leftToRight;
        }

        return head;
    }
}