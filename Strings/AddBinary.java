/*
---------------------------------------------------------
Problem: Add Binary

Platform: LeetCode

Difficulty: Easy

Approach:
Simulation using StringBuilder

Algorithm:
1. Initialize two pointers at the end of both binary strings.
2. Initialize a carry variable to 0.
3. Traverse both strings from right to left.
4. Add the current bits and the carry.
5. Append (sum % 2) to the result.
6. Update carry as (sum / 2).
7. Continue until both strings are processed and no carry remains.
8. Reverse the StringBuilder and return the final binary string.

Time Complexity:
O(max(n, m))

Space Complexity:
O(max(n, m))

Link:
https://leetcode.com/problems/add-binary/
---------------------------------------------------------
*/

class Solution {

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}