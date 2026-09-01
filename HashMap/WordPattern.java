/*
---------------------------------------------------------
Problem: Word Pattern

Platform: LeetCode

Difficulty: Easy

Approach:
HashMap + Bidirectional Mapping

Algorithm:
1. Split the string `s` into individual words.

2. If the number of words is different from the length of
   `pattern`, return false.

3. Use two HashMaps:
   - `charToWord` maps each pattern character to a word.
   - `wordToChar` maps each word back to its pattern character.

4. Traverse the pattern and words simultaneously.

5. For each character-word pair:
   - If the character is already mapped to a different word,
     return false.
   - If the word is already mapped to a different character,
     return false.

6. Store both mappings.

7. If all mappings remain consistent, return true.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/word-pattern/
---------------------------------------------------------
*/

class Solution {

    public boolean wordPattern(String pattern, String s) {

        // Split the string into individual words
        String[] words = s.split(" ");

        // Pattern and word count must be equal
        if (pattern.length() != words.length) {
            return false;
        }

        // Map pattern characters to words
        Map<Character, String> charToWord = new HashMap<>();

        // Map words back to pattern characters
        Map<String, Character> wordToChar = new HashMap<>();

        // Check every character-word pair
        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            // Check character -> word mapping
            if (charToWord.containsKey(c)
                    && !charToWord.get(c).equals(word)) {
                return false;
            }

            // Check word -> character mapping
            if (wordToChar.containsKey(word)
                    && wordToChar.get(word) != c) {
                return false;
            }

            // Store both mappings
            charToWord.put(c, word);
            wordToChar.put(word, c);
        }

        return true;
    }
}