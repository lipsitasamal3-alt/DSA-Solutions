/*
---------------------------------------------------------
Problem: Pow(x, n)

Platform: LeetCode

Difficulty: Medium

Approach:
Binary Exponentiation (Fast Exponentiation)

Algorithm:
1. Convert n to a long to handle Integer.MIN_VALUE.
2. If n is negative:
   - Replace x with 1/x.
   - Make n positive.
3. Initialize the result as 1.
4. While n > 0:
   - If n is odd, multiply the result by the current power.
   - Square the current power.
   - Divide n by 2.
5. Return the result.

Time Complexity: O(log n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/powx-n/
---------------------------------------------------------
*/

class Solution {

    public double myPow(double x, int n) {

        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {

            if (N % 2 == 1) {
                result *= currentProduct;
            }

            currentProduct *= currentProduct;
            N /= 2;
        }

        return result;
    }
}