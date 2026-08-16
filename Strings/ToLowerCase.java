/*
---------------------------------------------------------
Problem: To Lower Case

Platform: LeetCode

Difficulty: Easy

Approach:
String + ASCII Character Manipulation

Algorithm:
1. Convert the string into a character array so that
   individual characters can be modified.

2. Traverse every character in the array.

3. Check whether the character is an uppercase English
   letter between 'A' and 'Z'.

4. If it is uppercase, add 32 to its ASCII value to
   convert it into the corresponding lowercase letter.

5. Convert the character array back into a String and
   return it.

Time Complexity:
O(n)

Space Complexity:
O(n)
(The character array requires O(n) space.)

Link:
https://leetcode.com/problems/to-lower-case/
---------------------------------------------------------
*/

class Solution {

    public String toLowerCase(String s) {

        // Convert string to character array
        char[] chars = s.toCharArray();

        // Traverse all characters
        for (int i = 0; i < chars.length; i++) {

            // Check if character is uppercase
            if (chars[i] >= 'A' && chars[i] <= 'Z') {

                // Convert uppercase to lowercase using ASCII
                chars[i] = (char) (chars[i] + 32);
            }
        }

        // Convert character array back to String
        return new String(chars);
    }
}