/*
---------------------------------------------------------
Problem: Longest Substring Without Repeating Characters

Platform: LeetCode

Difficulty: Medium

Approach:
Sliding Window + HashMap

Algorithm:
1. Use a HashMap to store the latest index of each character.
2. Maintain a sliding window using the `start` pointer.
3. For each character, check whether it already exists in the current window.
4. If it does, move `start` to one position after its previous occurrence.
5. Update the character's latest index in the HashMap.
6. Calculate and track the maximum window length.

Time Complexity:
O(n)

Space Complexity:
O(min(n, charset size))

Link:
https://leetcode.com/problems/longest-substring-without-repeating-characters/
---------------------------------------------------------
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // Move start if the character is already in the window
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                start = map.get(currentChar) + 1;
            }

            // Store the latest index of the character
            map.put(currentChar, end);

            // Update maximum substring length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}