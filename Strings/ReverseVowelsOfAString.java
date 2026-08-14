/*
---------------------------------------------------------
Problem: Reverse Vowels of a String

Platform: LeetCode

Difficulty: Easy

Approach:
Strings + Two Pointers

Algorithm:
1. Convert the string to a character array.
2. Use two pointers:
      left  → beginning
      right → end
3. Move `left` forward until it points to a vowel.
4. Move `right` backward until it points to a vowel.
5. Swap the two vowels.
6. Move both pointers inward.
7. Continue until the pointers meet.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/reverse-vowels-of-a-string/
---------------------------------------------------------
*/

class Solution {

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        // Lookup table for vowels
        boolean[] vowels = new boolean[128];

        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels[c] = true;
        }

        while (left < right) {

            // Find vowel from the left
            while (left < right && !vowels[chars[left]]) {
                left++;
            }

            // Find vowel from the right
            while (left < right && !vowels[chars[right]]) {
                right--;
            }

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}