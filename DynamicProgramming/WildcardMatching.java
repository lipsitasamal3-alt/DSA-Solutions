/*
---------------------------------------------------------
Problem: Wildcard Matching

Platform: LeetCode

Difficulty: Hard

Approach:
Dynamic Programming (2D DP)

Algorithm:
1. Create a DP table of size (m + 1) × (n + 1),
   where m is the length of the string and n is the
   length of the pattern.
2. Initialize dp[0][0] as true.
3. Fill the first row for consecutive '*' characters,
   since they can match an empty string.
4. Traverse both the string and pattern:
   - If characters match or pattern contains '?',
     copy the diagonal value.
   - If pattern contains '*',
     consider matching zero characters or one/more characters.
5. Return the value at dp[m][n].

Time Complexity:
O(m × n)

Space Complexity:
O(m × n)

Link:
https://leetcode.com/problems/wildcard-matching/
---------------------------------------------------------
*/

class Solution {

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {

            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (p.charAt(j - 1) == s.charAt(i - 1) ||
                    p.charAt(j - 1) == '?') {

                    dp[i][j] = dp[i - 1][j - 1];

                } else if (p.charAt(j - 1) == '*') {

                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}