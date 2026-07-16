/*
---------------------------------------------------------
Problem: Number of Digit One

Platform: LeetCode

Difficulty: Hard

Approach:
Mathematical Digit Analysis

Algorithm:
1. Iterate through each digit position:
   - Ones, Tens, Hundreds, etc.
2. For each position:
   - Calculate how many complete cycles contribute
     occurrences of digit '1'.
   - Calculate the contribution from the partial cycle.
3. Add the contributions to the total count.
4. Continue until all digit positions are processed.
5. Return the total number of digit '1's.

Time Complexity:
O(log₁₀ n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/number-of-digit-one/
---------------------------------------------------------
*/

class Solution {

    public int countDigitOne(int n) {

        int count = 0;

        for (long i = 1; i <= n; i *= 10) {

            long divider = i * 10;

            count += (n / divider) * i;

            long remainder = n % divider;

            count += Math.min(
                    Math.max(remainder - i + 1, 0),
                    i
            );
        }

        return count;
    }
}