/*
---------------------------------------------------------
Problem: Substring with Concatenation of All Words

Platform: LeetCode

Difficulty: Hard

Approach:
Sliding Window with HashMap

Algorithm:
1. Handle edge cases where the input string or words array is empty.
2. Store the frequency of each word in a HashMap.
3. Calculate the length of each word, total number of words, and total substring length.
4. Traverse the string using multiple sliding windows starting from each possible offset.
5. Expand the window by one word at a time.
6. If the current word exists in the HashMap:
   - Update its frequency in the current window.
   - If its count exceeds the required frequency, shrink the window from the left.
7. When the window contains all words exactly once, add the starting index to the result.
8. If an invalid word is encountered, reset the window.
9. Return the list of starting indices.

Time Complexity:
O(n × wordLength)

Space Complexity:
O(k)

Link:
https://leetcode.com/problems/substring-with-concatenation-of-all-words/
---------------------------------------------------------
*/

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int sLen = s.length();

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {

            int left = i;
            int right = i;
            int wordsUsed = 0;

            Map<String, Integer> currentCount = new HashMap<>();

            while (right + wordLen <= sLen) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {

                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    wordsUsed++;

                    while (currentCount.get(word) > wordCount.get(word)) {

                        String leftWord = s.substring(left, left + wordLen);

                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);

                        wordsUsed--;
                        left += wordLen;
                    }

                    if (wordsUsed == numWords) {
                        result.add(left);
                    }

                } else {

                    currentCount.clear();
                    wordsUsed = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}