/*
---------------------------------------------------------
Problem: Insert Interval

Platform: LeetCode

Difficulty: Medium

Approach:
Interval Merging

Algorithm:
1. Create a list to store the resulting intervals.
2. Add all intervals that end before the new interval begins.
3. Merge all overlapping intervals with the new interval.
4. Add the merged interval to the result.
5. Add all remaining non-overlapping intervals.
6. Convert the list to a 2D array and return it.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/insert-interval/
---------------------------------------------------------
*/

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}