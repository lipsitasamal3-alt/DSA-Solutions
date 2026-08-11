/*
---------------------------------------------------------
Problem: Teemo Attacking

Platform: LeetCode

Difficulty: Medium

Approach:
Arrays + Interval Overlap

Algorithm:
1. For every attack except the last one, calculate the time
   until the next attack.
2. The poisoned duration contributed by that attack is:

      min(timeSeries[i + 1] - timeSeries[i], duration)

   This prevents counting overlapping poison time twice.
3. Add the full `duration` for the final attack.

Example:
timeSeries = [1, 4], duration = 2

Attack at 1 → poisoned from 1 to 3 = 2
Attack at 4 → poisoned from 4 to 6 = 2

Total = 4

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/teemo-attacking/
---------------------------------------------------------
*/

class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        int totalPoisoned = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {

            totalPoisoned += Math.min(
                timeSeries[i + 1] - timeSeries[i],
                duration
            );
        }

        // Last attack always contributes the full duration
        totalPoisoned += duration;

        return totalPoisoned;
    }
}