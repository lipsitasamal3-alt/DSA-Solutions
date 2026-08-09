/*
---------------------------------------------------------
Problem: Number of Substrings With Only 1s

Platform: LeetCode

Difficulty: Medium

Approach:
String + Counting

Algorithm:
1. Maintain `currentStreak`, which represents the number of
   consecutive '1's ending at the current position.
2. Whenever we encounter a '1':
   - Increase `currentStreak`.
   - Add it to `totalSubstrings`.
3. Whenever we encounter a '0':
   - Reset `currentStreak` to 0.
4. Why add `currentStreak`?
   
   For a streak of 1s:
       "1"       → 1 substring
       "11"      → 3 substrings
       "111"     → 6 substrings

   A streak of length k contributes:
       k × (k + 1) / 2

   Adding the current streak at each position calculates this
   incrementally.
5. Take the result modulo 1,000,000,007.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/number-of-substrings-with-only-1s/
---------------------------------------------------------
*/

class Solution {

    public int numSub(String s) {

        final int MOD = 1_000_000_007;

        long totalSubstrings = 0;
        int currentStreak = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {

                currentStreak++;

                totalSubstrings =
                    (totalSubstrings + currentStreak) % MOD;

            } else {

                currentStreak = 0;
            }
        }

        return (int) totalSubstrings;
    }
}