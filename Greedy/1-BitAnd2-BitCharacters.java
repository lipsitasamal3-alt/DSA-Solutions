/*
---------------------------------------------------------
Problem: 1-bit and 2-bit Characters

Platform: LeetCode

Difficulty: Easy

Approach:
Greedy + Array Traversal

Algorithm:
1. Start from the first bit using index `i = 0`.

2. Traverse the array until reaching the last bit.

3. If bits[i] == 0, it represents a one-bit character,
   so move one position forward.

4. If bits[i] == 1, it must be the beginning of a
   two-bit character, so skip the next two positions.

5. Stop when `i` reaches or passes the last position.

6. If `i == n - 1`, the last bit is a one-bit character,
   so return true.

7. Otherwise, the last bit was part of a two-bit character,
   so return false.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/1-bit-and-2-bit-characters/
---------------------------------------------------------
*/

class Solution {

    public boolean isOneBitCharacter(int[] bits) {

        int i = 0;
        int n = bits.length;

        // Traverse until the last bit
        while (i < n - 1) {

            if (bits[i] == 1) {

                // 1 starts a two-bit character
                i += 2;

            } else {

                // 0 represents a one-bit character
                i += 1;
            }
        }

        // Check whether the last bit is a one-bit character
        return i == n - 1;
    }
}