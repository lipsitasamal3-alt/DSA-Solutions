/*
---------------------------------------------------------
Problem: Decode String

Platform: LeetCode

Difficulty: Medium

Approach:
Stack

Algorithm:
1. Initialize two stacks:
   - One for repetition counts.
   - One for previously built strings.
2. Traverse the input string character by character.
3. If the character is a digit:
   - Build the complete repeat count.
4. If the character is '[':
   - Push the current repeat count onto the count stack.
   - Push the current string onto the string stack.
   - Reset the current string and repeat count.
5. If the character is ']':
   - Pop the previous string and repeat count.
   - Append the current string to the previous string the required number of times.
   - Update the current string.
6. If the character is a letter:
   - Append it to the current string.
7. Return the final decoded string.

Time Complexity:
O(n × k)
(where k is the maximum repetition factor)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/decode-string/
---------------------------------------------------------
*/

class Solution {

    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {

                currentNumber = currentNumber * 10 + (currentChar - '0');

            } else if (currentChar == '[') {

                countStack.push(currentNumber);
                stringStack.push(currentString);

                currentString = new StringBuilder();
                currentNumber = 0;

            } else if (currentChar == ']') {

                StringBuilder decodedString = stringStack.pop();
                int repeatTimes = countStack.pop();

                for (int j = 0; j < repeatTimes; j++) {
                    decodedString.append(currentString);
                }

                currentString = decodedString;

            } else {

                currentString.append(currentChar);
            }
        }

        return currentString.toString();
    }
}