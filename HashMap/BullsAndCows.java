/*
---------------------------------------------------------
Problem: Bulls and Cows

Platform: LeetCode

Difficulty: Medium

Approach:
Frequency Counting

Algorithm:
1. Initialize `bulls` and `cows` to count exact matches and
   value matches respectively.

2. Create two arrays of size 10:
   - `secretCounts` stores unmatched digits from `secret`.
   - `guessCounts` stores unmatched digits from `guess`.

3. Traverse both strings simultaneously.
   - If the digits at the same position are equal, it is a
     bull, so increment `bulls`.
   - Otherwise, store both digits in their respective
     frequency arrays.

4. After processing all positions, calculate cows.
   For every digit from 0 to 9, add the minimum frequency
   present in both arrays.

5. Return the result in the required format:
   `bullsA cowsB`

Time Complexity:
O(n)

Space Complexity:
O(1)
(Only two arrays of size 10 are used.)

Link:
https://leetcode.com/problems/bulls-and-cows/
---------------------------------------------------------
*/

class Solution {

    public String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;

        // Frequency of unmatched digits in secret
        int[] secretCounts = new int[10];

        // Frequency of unmatched digits in guess
        int[] guessCounts = new int[10];

        // Check each position
        for (int i = 0; i < secret.length(); i++) {

            char s = secret.charAt(i);
            char g = guess.charAt(i);

            // Same digit at the same position
            if (s == g) {
                bulls++;
            } else {
                // Store unmatched digits
                secretCounts[s - '0']++;
                guessCounts[g - '0']++;
            }
        }

        // Count digits that exist in both strings
        for (int i = 0; i < 10; i++) {
            cows += Math.min(
                secretCounts[i],
                guessCounts[i]
            );
        }

        // Return result in "xAyB" format
        return bulls + "A" + cows + "B";
    }
}