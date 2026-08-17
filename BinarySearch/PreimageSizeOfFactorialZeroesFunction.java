/*
---------------------------------------------------------
Problem: Preimage Size of Factorial Zeroes Function

Platform: LeetCode

Difficulty: Hard

Approach:
Binary Search + Mathematical Counting

Algorithm:
1. The number of trailing zeroes in `n!` is determined by
   the number of factors of 5:
   
   zeroes(n!) = n/5 + n/25 + n/125 + ...

2. Use binary search to find whether there exists a number
   whose factorial contains exactly `k` trailing zeroes.

3. The search range is:
   - `low = 0`
   - `high = 5 * (k + 1)`

4. For each `mid`, calculate the number of trailing zeroes
   in `mid!` using `countZeroes()`.

5. If the number of zeroes equals `k`, return 5.
   For this problem, whenever a valid preimage exists, there
   are exactly five consecutive numbers with `k` trailing
   zeroes.

6. If the number of zeroes is less than `k`, search the
   right half.

7. If the number of zeroes is greater than `k`, search the
   left half.

8. If no number produces exactly `k` trailing zeroes, return 0.

Time Complexity:
O(log k * log k)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/
---------------------------------------------------------
*/

class Solution {

    public int preimageSizeFZF(int k) {

        long low = 0;
        long high = 5L * (k + 1);

        // Binary search for a number whose factorial
        // has exactly k trailing zeroes
        while (low <= high) {

            long mid = low + (high - low) / 2;

            long val = countZeroes(mid);

            if (val == k) {

                // Every valid preimage contains exactly
                // five consecutive numbers
                return 5;

            } else if (val < k) {

                // Need a larger number
                low = mid + 1;

            } else {

                // Need a smaller number
                high = mid - 1;
            }
        }

        return 0;
    }

    private long countZeroes(long x) {

        long ans = 0;

        // Count factors of 5 in x!
        while (x > 0) {

            ans += x / 5;
            x /= 5;
        }

        return ans;
    }
}