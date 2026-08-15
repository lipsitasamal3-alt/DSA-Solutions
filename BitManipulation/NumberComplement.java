/*
---------------------------------------------------------
Problem: Number Complement

Platform: LeetCode

Difficulty: Easy

Approach:
Bit Manipulation

Algorithm:
1. Find the number of bits required to represent `num`
   using logarithm.

2. Create a mask containing all 1s for the same number
   of bits.

3. XOR `num` with the mask.
   - 0 ^ 1 = 1
   - 1 ^ 1 = 0

4. Return the resulting number as the complement.

Time Complexity:
O(1)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/number-complement/
---------------------------------------------------------
*/

class Solution {

    public int findComplement(int num) {

        // Find the number of bits in num
        int bitLength = (int) (Math.log(num) / Math.log(2)) + 1;

        // Create a mask with bitLength number of 1s
        int mask = (1 << bitLength) - 1;

        // XOR num with the mask to get its complement
        return num ^ mask;
    }
}