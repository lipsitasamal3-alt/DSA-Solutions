/*
---------------------------------------------------------
Problem: Count Primes

Platform: LeetCode

Difficulty: Medium

Approach:
Math + Sieve of Eratosthenes

Algorithm:
1. Create a boolean array `isComposite`.
   - false → potentially prime
   - true  → composite

2. Start from 2 and go up to √n.

3. If `i` is not composite, mark all multiples of `i`
   starting from `i * i` as composite.

4. Finally, count all numbers from 2 to n - 1 that are
   not composite.

Why start marking from i * i?
All smaller multiples of i have already been marked by
smaller prime factors.

Time Complexity:
O(n log log n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/count-primes/
---------------------------------------------------------
*/

class Solution {

    public int countPrimes(int n) {

        if (n <= 2) {
            return 0;
        }

        boolean[] isComposite = new boolean[n];

        int count = 0;

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {

            if (!isComposite[i]) {

                for (int j = i * i; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Count primes
        for (int i = 2; i < n; i++) {

            if (!isComposite[i]) {
                count++;
            }
        }

        return count;
    }
}