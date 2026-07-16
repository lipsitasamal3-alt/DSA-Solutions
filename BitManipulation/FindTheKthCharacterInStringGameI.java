/*
---------------------------------------------------------
Problem: Find the K-th Character in String Game I

Platform: LeetCode

Difficulty: Easy

Approach:
Bit Manipulation

Algorithm:
1. Compute k - 1.
2. Count the number of set bits in k - 1.
3. The number of set bits represents the number of
   character shifts from 'a'.
4. Compute the character by adding
   (set bits % 26) to 'a'.
5. Return the resulting character.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
---------------------------------------------------------
*/

class Solution {

    public char kthCharacter(int k) {

        int shifts = Integer.bitCount(k - 1);

        return (char) ('a' + (shifts % 26));
    }
}