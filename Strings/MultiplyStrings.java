/*
---------------------------------------------------------
Problem: Multiply Strings

Platform: LeetCode

Difficulty: Medium

Approach:
Simulation using Array for Digit Multiplication

Algorithm:
1. If either string is "0", return "0".
2. Create an integer array of size (m + n) to store the result.
3. Traverse both strings from right to left.
4. Multiply each pair of digits.
5. Add the product to the appropriate positions in the result array.
6. Store the carry and remainder accordingly.
7. Build the final answer by skipping leading zeros.
8. Return the resulting string.

Time Complexity:
O(m × n)

Space Complexity:
O(m + n)

Link:
https://leetcode.com/problems/multiply-strings/
---------------------------------------------------------
*/

class Solution {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int digit : result) {

            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.toString();
    }
}