/*
---------------------------------------------------------
Problem: Merge Intervals

Platform: LeetCode

Difficulty: Medium

Approach:
Sorting + Interval Merging

Algorithm:
1. Handle the edge case where the input array has
   zero or one interval.
2. Sort the intervals based on their starting points.
3. Create a list to store the merged intervals.
4. Traverse each interval:
   - If there is no overlap with the last merged interval,
     add the current interval.
   - Otherwise, merge the intervals by updating the end
     of the last interval.
5. Convert the merged list into a 2D array.
6. Return the merged intervals.

Time Complexity:
O(n log n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/merge-intervals/
---------------------------------------------------------
*/

class Solution {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {

                merged.add(interval);

            } else {

                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}