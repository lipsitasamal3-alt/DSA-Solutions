/*
---------------------------------------------------------
Problem: Longest Consecutive Sequence

Platform: LeetCode

Difficulty: Medium

Approach:
HashSet + Sequence Traversal

Algorithm:
1. Store all elements of the array in a HashSet.
   This allows O(1) average-time lookup.

2. Traverse every unique number in the set.

3. A number is the beginning of a consecutive sequence
   if `num - 1` does not exist in the set.

4. Starting from such a number, keep checking whether the
   next consecutive number exists.

5. Count the length of the current consecutive sequence.

6. Update `longestStreak` with the maximum sequence length
   found.

7. Return the longest consecutive sequence length.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/longest-consecutive-sequence/
---------------------------------------------------------
*/

class Solution {

    public int longestConsecutive(int[] nums) {

        // Store all numbers for O(1) average lookup
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Traverse all unique numbers
        for (int num : numSet) {

            // Start only from the beginning of a sequence
            if (!numSet.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                // Find consecutive numbers
                while (numSet.contains(currentNum + 1)) {

                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longest sequence
                longestStreak =
                        Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}