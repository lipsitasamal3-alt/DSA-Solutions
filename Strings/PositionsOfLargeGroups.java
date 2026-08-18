/*
---------------------------------------------------------
Problem: Positions of Large Groups

Platform: LeetCode

Difficulty: Easy

Approach:
String Traversal + Two Pointers

Algorithm:
1. Use `start` to store the starting index of the current
   group of identical characters.

2. Traverse the string from left to right.

3. A group ends when:
   - The current character is different from the next
     character, or
   - We reach the last character.

4. Calculate the size of the current group using:
   `i - start + 1`.

5. If the group contains at least 3 characters, store its
   starting and ending indices in the result.

6. Start a new group from `i + 1`.

7. Return all large group intervals.

Time Complexity:
O(n)

Space Complexity:
O(n)
(The result list requires O(n) space in the worst case.)

Link:
https://leetcode.com/problems/positions-of-large-groups/
---------------------------------------------------------
*/

class Solution {

    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> result = new ArrayList<>();

        int n = s.length();
        int start = 0;

        // Traverse the string
        for (int i = 0; i < n; i++) {

            // Check if the current group ends
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {

                // Check if the group has at least 3 characters
                if (i - start + 1 >= 3) {

                    List<Integer> interval = new ArrayList<>();

                    interval.add(start);
                    interval.add(i);

                    result.add(interval);
                }

                // Start the next group
                start = i + 1;
            }
        }

        return result;
    }
}