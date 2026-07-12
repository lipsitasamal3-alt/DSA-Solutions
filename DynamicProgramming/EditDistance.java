/*
---------------------------------------------------------
Problem: Edit Distance

Platform: LeetCode

Difficulty: Hard

Approach:
Dynamic Programming (2D DP)

Algorithm:
1. Let m and n be the lengths of word1 and word2.
2. Create a DP table of size (m + 1) × (n + 1).
3. Initialize:
   - dp[i][0] = i (delete all characters)
   - dp[0][j] = j (insert all characters)
4. Traverse both strings:
   - If characters match, copy the diagonal value.
   - Otherwise, take 1 + minimum of:
     a) Delete operation
     b) Insert operation
     c) Replace operation
5. Return dp[m][n] as the minimum number of operations.

Time Complexity:
O(m × n)

Space Complexity:
O(m × n)

Link:
https://leetcode.com/problems/edit-distance/
---------------------------------------------------------
*/

class Solution {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])
                    );
                }
            }
        }

        return dp[m][n];
    }
}