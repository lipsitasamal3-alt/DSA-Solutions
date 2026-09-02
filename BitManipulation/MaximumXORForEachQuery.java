/*
---------------------------------------------------------
Problem: Maximum XOR for Each Query

Platform: LeetCode

Difficulty: Medium

Approach:
Bit Manipulation + Greedy

Algorithm:
1. Build a bit mask from the most significant bit to the least significant bit.
2. Store the prefixes of all numbers using the current mask.
3. Try setting the current bit in maxXor.
4. Check whether two prefixes can produce the candidate XOR.
5. If possible, keep the bit; otherwise, leave it unset.
6. Return the maximum possible XOR.

Time Complexity:
O(31 × n) = O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/maximum-xor-for-each-query/
---------------------------------------------------------
*/

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        int mask = 0;

        // Check bits from most significant to least significant
        for (int i = 30; i >= 0; i--) {

            mask |= (1 << i);

            Set<Integer> prefixes = new HashSet<>();

            // Store prefixes using the current mask
            for (int num : nums) {
                prefixes.add(num & mask);
            }

            // Try setting the current bit
            int candidate = maxXor | (1 << i);

            // Check if candidate XOR is achievable
            for (int prefix : prefixes) {
                if (prefixes.contains(prefix ^ candidate)) {
                    maxXor = candidate;
                    break;
                }
            }
        }

        return maxXor;
    }
}