/*
---------------------------------------------------------
Problem: Count Collisions of Monkeys on a Polygon

Platform: LeetCode

Difficulty: Medium

Approach:
Math (Binary Exponentiation)

Algorithm:
1. Compute 2ⁿ modulo 10⁹ + 7 using binary exponentiation.
2. Subtract 2 to exclude the two non-collision cases:
   - All monkeys move clockwise.
   - All monkeys move counterclockwise.
3. Add the modulus before taking modulo again to
   avoid negative values.
4. Return the final answer.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon/
---------------------------------------------------------
*/

class Solution {

    public int monkeyMove(int n) {

        long mod = 1_000_000_007L;

        long ans = power(2, n, mod) - 2;

        return (int) ((ans + mod) % mod);
    }

    private long power(long base, int exp, long mod) {

        long result = 1;

        base %= mod;

        while (exp > 0) {

            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}