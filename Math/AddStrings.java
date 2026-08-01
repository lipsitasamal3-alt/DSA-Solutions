/*
---------------------------------------------------------
Problem: Add Strings

Platform: LeetCode

Difficulty: Easy

Approach:
Simulation

Algorithm:
1. Initialize two pointers at the end of both strings.
2. Maintain a carry initialized to 0.
3. While either string has remaining digits or carry is non-zero:
   - Read the current digit from each string (or 0 if exhausted).
   - Compute the sum of both digits and the carry.
   - Append the last digit of the sum to the result.
   - Update the carry.
   - Move both pointers one position to the left.
4. Reverse the constructed string.
5. Return the final result.

Time Complexity:
O(max(n, m))

Space Complexity:
O(max(n, m))

Link:
https://leetcode.com/problems/add-strings/
---------------------------------------------------------
*/

class Solution {

    public String addStrings(String num1, String num2) {

        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            result.append(sum % 10);

            i--;
            j--;
        }

        return result.reverse().toString();
    }
}