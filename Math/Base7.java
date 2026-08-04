/*
---------------------------------------------------------
Problem: Base 7

Platform: LeetCode

Difficulty: Easy

Approach:
Math

Algorithm:
1. If the number is 0, return "0".
2. Determine whether the number is negative.
3. Convert the number to its absolute value.
4. Repeatedly:
   - Append the remainder when dividing by 7.
   - Divide the number by 7.
5. If the original number was negative, append '-'.
6. Reverse the constructed string and return it.

Time Complexity:
O(log₇ n)

Space Complexity:
O(log₇ n)

Link:
https://leetcode.com/problems/base-7/
---------------------------------------------------------
*/

class Solution {

    public String convertToBase7(int num) {

        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        boolean isNegative = num < 0;
        long n = Math.abs((long) num);

        while (n > 0) {
            result.append(n % 7);
            n /= 7;
        }

        if (isNegative) {
            result.append("-");
        }

        return result.reverse().toString();
    }
}