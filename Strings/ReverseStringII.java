/*
---------------------------------------------------------
Problem: Reverse String II

Platform: LeetCode

Difficulty: Easy

Approach:
Strings + Two Pointers

Algorithm:
1. Convert the string into a character array so that it can
   be modified directly.

2. Process the string in blocks of `2k` characters.

3. For every block:
   - Reverse the first `k` characters.
   - Leave the next `k` characters unchanged.

4. If fewer than `k` characters remain, reverse all of them.

5. Convert the character array back into a String.

Time Complexity:
O(n)

Space Complexity:
O(n) because of the character array.

Link:
https://leetcode.com/problems/reverse-string-ii/
---------------------------------------------------------
*/

class Solution {

    public String reverseStr(String s, int k) {

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i += 2 * k) {

            int start = i;

            int end = Math.min(i + k - 1, arr.length - 1);

            // Reverse the first k characters
            while (start < end) {

                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }

        return new String(arr);
    }
}