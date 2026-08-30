/*
---------------------------------------------------------
Problem: Ransom Note

Platform: LeetCode

Difficulty: Easy

Approach:
Frequency Counting

Algorithm:
1. Create an array of size 26 to store the frequency of
   each lowercase English letter in `magazine`.

2. Traverse `magazine` and increase the frequency of each
   character.

3. Traverse `ransomNote` and decrease the frequency of each
   required character.

4. If the frequency of any character becomes negative, the
   magazine does not contain enough copies of that character.
   Return `false`.

5. If all characters can be constructed, return `true`.

Time Complexity:
O(n + m)

Space Complexity:
O(1)
(Only 26 character frequencies are stored.)

Link:
https://leetcode.com/problems/ransom-note/
---------------------------------------------------------
*/

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        // Store frequency of each character in magazine
        int[] counts = new int[26];

        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        // Check whether magazine contains enough characters
        for (char c : ransomNote.toCharArray()) {

            counts[c - 'a']--;

            // Not enough occurrences of this character
            if (counts[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}