/*
---------------------------------------------------------
Problem: Find Right Interval

Platform: LeetCode

Difficulty: Medium

Approach:
Intervals + TreeMap

Algorithm:
1. Store every interval's starting point and its original index
   in a TreeMap.

      startMap.put(intervals[i][0], i)

2. For every interval, take its ending point.

3. Use `ceilingEntry(endValue)` to find the interval whose
   starting point is the smallest value >= the current
   interval's ending point.

4. If such an interval exists, store its original index.
   Otherwise, store -1.

Why TreeMap?
TreeMap keeps keys sorted and provides `ceilingEntry()`,
which efficiently finds the smallest key greater than or
equal to a given value.

Time Complexity:
O(n log n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/find-right-interval/
---------------------------------------------------------
*/

class Solution {

    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[] result = new int[n];

        TreeMap<Integer, Integer> startMap = new TreeMap<>();

        // Store start value -> original index
        for (int i = 0; i < n; i++) {
            startMap.put(intervals[i][0], i);
        }

        for (int i = 0; i < n; i++) {

            int endValue = intervals[i][1];

            // Find smallest start >= current end
            Map.Entry<Integer, Integer> entry =
                    startMap.ceilingEntry(endValue);

            if (entry != null) {
                result[i] = entry.getValue();
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}