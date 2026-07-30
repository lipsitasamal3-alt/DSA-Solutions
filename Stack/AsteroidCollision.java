/*
---------------------------------------------------------
Problem: Asteroid Collision

Platform: LeetCode

Difficulty: Medium

Approach:
Stack Simulation

Algorithm:
1. Use the input array itself as a stack.
2. Maintain a pointer (`top`) representing the top of the stack.
3. Traverse each asteroid:
   - Assume the asteroid survives.
   - While the current asteroid is moving left and the top asteroid
     is moving right, a collision occurs.
   - If the top asteroid is smaller, remove it and continue.
   - If both are equal, remove the top asteroid and destroy the
     current asteroid.
   - If the top asteroid is larger, destroy the current asteroid.
4. If the current asteroid survives all collisions, push it onto
   the stack.
5. Copy the remaining asteroids into the result array.
6. Return the result.

Time Complexity:
O(n)

Space Complexity:
O(1) (excluding the output array)

Link:
https://leetcode.com/problems/asteroid-collision/
---------------------------------------------------------
*/

class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        int top = -1;

        for (int asteroid : asteroids) {

            boolean alive = true;

            while (top >= 0 &&
                   asteroid < 0 &&
                   asteroids[top] > 0) {

                if (asteroids[top] < -asteroid) {

                    top--;
                    continue;

                } else if (asteroids[top] == -asteroid) {

                    top--;
                }

                alive = false;
                break;
            }

            if (alive) {
                asteroids[++top] = asteroid;
            }
        }

        int[] result = new int[top + 1];
        System.arraycopy(asteroids, 0, result, 0, top + 1);

        return result;
    }
}