/*
---------------------------------------------------------
Problem: Minimum Moves to Equal Array Elements II

Platform: LeetCode

Difficulty: Medium

Approach:
Sorting + Math

Algorithm:
1. Sort the array in non-decreasing order.
2. Choose the median element.
3. Compute the absolute difference between each element and the
   median.
4. Sum all the absolute differences.
5. Return the total number of moves.

Explanation:
- The median minimizes the sum of absolute differences, making it
  the optimal target value.

Time Complexity:
O(n log n)

Space Complexity:
O(1) (excluding the sorting algorithm's recursion stack)

Link:
https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
---------------------------------------------------------
*/

class Solution {

    public int minMoves2(int[] nums) {

        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}