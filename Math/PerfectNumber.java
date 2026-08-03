/*
---------------------------------------------------------
Problem: Perfect Number

Platform: LeetCode

Difficulty: Easy

Approach:
Math

Algorithm:
1. A perfect number is equal to the sum of its positive divisors
   excluding itself.
2. If the number is less than or equal to 1, return false.
3. Initialize the divisor sum as 1 since 1 is a divisor of every
   number greater than 1.
4. Iterate from 2 up to √num:
   - If the current number divides `num`:
     - Add the divisor to the sum.
     - If it is not the square root of `num`, also add its paired
       divisor (`num / i`).
5. Return true if the divisor sum equals the original number;
   otherwise, return false.

Time Complexity:
O(√n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/perfect-number/
---------------------------------------------------------
*/

class Solution {

    public boolean checkPerfectNumber(int num) {

        if (num <= 1) {
            return false;
        }

        int divisorSum = 1;

        for (int i = 2; i * i <= num; i++) {

            if (num % i == 0) {

                divisorSum += i;

                if (i * i != num) {
                    divisorSum += num / i;
                }
            }
        }

        return divisorSum == num;
    }
}