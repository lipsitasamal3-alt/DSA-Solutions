/*
---------------------------------------------------------
Problem: Valid Number

Platform: LeetCode

Difficulty: Hard

Approach:
String Parsing + State Tracking

Algorithm:
1. Maintain three boolean variables:
   - `seenDigit` → whether a digit has been encountered.
   - `seenDot`   → whether a decimal point has been used.
   - `seenE`     → whether an exponent has been used.

2. Traverse the string character by character.

3. If the character is a digit:
   - Mark `seenDigit` as true.

4. If the character is '+' or '-':
   - It is valid only at the beginning of the string or
     immediately after 'e' or 'E'.

5. If the character is 'e' or 'E':
   - It cannot appear more than once.
   - A digit must appear before it.
   - Reset `seenDigit` because the exponent must contain
     at least one digit.

6. If the character is '.':
   - It cannot appear more than once.
   - It cannot appear after an exponent.

7. Any other character makes the number invalid.

8. At the end, `seenDigit` must be true to ensure that
   the string ends with a valid digit.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/valid-number/
---------------------------------------------------------
*/

class Solution {

    public boolean isNumber(String s) {

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Check for a digit
            if (Character.isDigit(ch)) {

                seenDigit = true;

            // Check for '+' or '-'
            } else if (ch == '+' || ch == '-') {

                // Sign is valid only at the beginning or
                // immediately after 'e' or 'E'
                if (i > 0
                        && s.charAt(i - 1) != 'e'
                        && s.charAt(i - 1) != 'E') {
                    return false;
                }

            // Check for exponent
            } else if (ch == 'e' || ch == 'E') {

                // Exponent cannot appear more than once
                // and must have a digit before it
                if (seenE || !seenDigit) {
                    return false;
                }

                seenE = true;

                // Exponent must contain at least one digit
                seenDigit = false;

            // Check for decimal point
            } else if (ch == '.') {

                // Dot cannot appear more than once
                // or after an exponent
                if (seenDot || seenE) {
                    return false;
                }

                seenDot = true;

            } else {

                // Invalid character
                return false;
            }
        }

        // A valid number must end with a digit
        return seenDigit;
    }
}