/*
---------------------------------------------------------
Problem: Factorial Trailing Zeroes

Platform: LeetCode

Difficulty: Medium

Approach:
Math

Algorithm:
1. Initialize the count of trailing zeroes as 0.
2. While n is at least 5:
   - Divide n by 5.
   - Add the quotient to the count.
3. Repeat until n becomes less than 5.
4. Return the total count.

Explanation:
- Every trailing zero is formed by a pair of factors (2 × 5).
- Since factors of 2 are more frequent than factors of 5,
  the number of trailing zeroes depends on the number of
  factors of 5 in n!.

Time Complexity:
O(log₅(n))

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/factorial-trailing-zeroes/
---------------------------------------------------------
*/

class Solution {

    public int trailingZeroes(int n) {

        int count = 0;

        while (n >= 5) {

            n /= 5;
            count += n;
        }

        return count;
    }
}