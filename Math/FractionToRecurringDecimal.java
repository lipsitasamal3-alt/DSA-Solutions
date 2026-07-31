/*
---------------------------------------------------------
Problem: Fraction to Recurring Decimal

Platform: LeetCode

Difficulty: Medium

Approach:
HashMap + Simulation

Algorithm:
1. If the numerator is 0, return "0".
2. Determine the sign of the result.
3. Convert the numerator and denominator to positive long values
   to avoid integer overflow.
4. Append the integer part of the division.
5. If there is no remainder, return the result.
6. Otherwise:
   - Append a decimal point.
   - Use a HashMap to store each remainder and its position in
     the result string.
7. While the remainder is non-zero:
   - If the remainder has appeared before:
     - Insert '(' at its first occurrence.
     - Append ')' at the end.
     - Stop.
   - Store the current remainder and its position.
   - Multiply the remainder by 10.
   - Append the quotient digit.
   - Update the remainder.
8. Return the final decimal representation.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/fraction-to-recurring-decimal/
---------------------------------------------------------
*/

class Solution {

    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);

        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> seenRemainders = new HashMap<>();

        while (remainder != 0) {

            if (seenRemainders.containsKey(remainder)) {

                int index = seenRemainders.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            seenRemainders.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}