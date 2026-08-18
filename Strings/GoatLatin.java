/*
---------------------------------------------------------
Problem: Goat Latin

Platform: LeetCode

Difficulty: Easy

Approach:
String Manipulation + HashSet

Algorithm:
1. Create a HashSet containing all vowels, including both
   uppercase and lowercase vowels.

2. Split the sentence into individual words.

3. Process each word:
   - If the first character is a vowel, keep the word
     unchanged.
   - Otherwise, move the first character to the end.

4. Append "ma" to every word.

5. Append one additional 'a' for each word:
   - First word -> "a"
   - Second word -> "aa"
   - Third word -> "aaa"
   - and so on.

6. Add spaces between the transformed words.

7. Return the final sentence.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/goat-latin/
---------------------------------------------------------
*/

class Solution {

    public String toGoatLatin(String sentence) {

        // Store all vowels
        Set<Character> vowels = new HashSet<>();

        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }

        // Split sentence into words
        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        // Stores the required number of 'a' characters
        StringBuilder trailingA = new StringBuilder("a");

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            char firstChar = word.charAt(0);

            // Add space between words
            if (i > 0) {
                result.append(" ");
            }

            // Check whether the first character is a vowel
            if (vowels.contains(firstChar)) {

                // Keep the word unchanged
                result.append(word);

            } else {

                // Move the first character to the end
                result.append(word.substring(1))
                      .append(firstChar);
            }

            // Append "ma" and the required number of 'a's
            result.append("ma")
                  .append(trailingA);

            // Add one more 'a' for the next word
            trailingA.append("a");
        }

        return result.toString();
    }
}