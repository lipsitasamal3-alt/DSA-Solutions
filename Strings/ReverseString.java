/*
---------------------------------------------------------
Problem: Reverse String

Platform: LeetCode

Difficulty: Easy

Approach:
Strings + Two Pointers

Algorithm:
1. Use two pointers:
      left  → beginning of the array
      right → end of the array

2. Swap the characters at `left` and `right`.

3. Move:
      left++
      right--

4. Continue until the pointers meet.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/reverse-string/
---------------------------------------------------------
*/

class Solution {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}