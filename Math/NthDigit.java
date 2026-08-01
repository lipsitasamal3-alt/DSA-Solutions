/*
---------------------------------------------------------
Problem: Nth Digit

Platform: LeetCode

Difficulty: Medium

Approach:
Math

Algorithm:
1. Determine the digit length of the target number:
   - 1-digit numbers contribute 9 digits.
   - 2-digit numbers contribute 90 × 2 digits.
   - 3-digit numbers contribute 900 × 3 digits, and so on.
2. Subtract the total digits of each group until the target group
   containing the nth digit is found.
3. Compute the actual number containing the nth digit:
   - targetNumber = start + (n - 1) / digitLength
4. Convert the target number to a string.
5. Return the digit at index (n - 1) % digitLength.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/nth-digit/
---------------------------------------------------------
*/

class Solution {

    public int findNthDigit(int n) {

        int digitLength = 1;
        long count = 9;
        int start = 1;

        while ((long) digitLength * count < n) {

            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        int targetNumber = start + (n - 1) / digitLength;

        String number = Integer.toString(targetNumber);

        return number.charAt((n - 1) % digitLength) - '0';
    }
}