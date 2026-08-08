/*
---------------------------------------------------------
Problem: Convert Integer to the Sum of Two No-Zero Integers

Platform: LeetCode

Difficulty: Easy

Approach:
Math + Digit Manipulation

Algorithm:
1. Try every possible value of `a` from 1 to n - 1.
2. Calculate:
      b = n - a
3. Check whether both `a` and `b` contain no digit 0.
4. If both are No-Zero Integers, return [a, b].
5. The problem guarantees that a valid pair exists.

Helper Function:
- Extract each digit using `% 10`.
- If any digit is 0, return true.
- Otherwise, return false.

Time Complexity:
O(n × log n)

Space Complexity:
O(1), excluding the returned array.

Link:
https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
---------------------------------------------------------
*/

class Solution {

    public int[] getNoZeroIntegers(int n) {

        for (int a = 1; a < n; a++) {

            int b = n - a;

            if (!hasZero(a) && !hasZero(b)) {
                return new int[]{a, b};
            }
        }

        return new int[0];
    }

    private boolean hasZero(int num) {

        while (num > 0) {

            if (num % 10 == 0) {
                return true;
            }

            num /= 10;
        }

        return false;
    }
}