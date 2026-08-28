/*
---------------------------------------------------------
Problem: Isomorphic Strings

Platform: LeetCode

Difficulty: Easy

Approach:
Hashing + Character Mapping

Algorithm:
1. Create two arrays:
   - `mapSToT` stores the mapping from characters of `s`
     to characters of `t`.
   - `mapTToS` stores the reverse mapping from characters
     of `t` to characters of `s`.

2. Traverse both strings simultaneously.

3. For every pair of characters:
   - Check whether the character from `s` was already mapped
     to a different character in `t`.
   - Check whether the character from `t` was already mapped
     from a different character in `s`.

4. If either mapping is inconsistent, return `false`.

5. Otherwise, store both mappings and continue.

6. If all characters can be mapped consistently, return
   `true`.

Time Complexity:
O(n)

Space Complexity:
O(1)
(The two arrays have a fixed size of 256.)

Link:
https://leetcode.com/problems/isomorphic-strings/
---------------------------------------------------------
*/

class Solution {

    public boolean isIsomorphic(String s, String t) {

        // Map characters from s -> t
        int[] mapSToT = new int[256];

        // Map characters from t -> s
        int[] mapTToS = new int[256];

        // Traverse both strings
        for (int i = 0; i < s.length(); i++) {

            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check whether charS is already mapped
            // to a different character
            if (mapSToT[charS] != 0
                    && mapSToT[charS] != charT) {
                return false;
            }

            // Check whether charT is already mapped
            // from a different character
            if (mapTToS[charT] != 0
                    && mapTToS[charT] != charS) {
                return false;
            }

            // Store both mappings
            mapSToT[charS] = charT;
            mapTToS[charT] = charS;
        }

        return true;
    }
}