/*
---------------------------------------------------------
Problem: Minimum Moves to Equal Array Elements

Platform: LeetCode

Difficulty: Medium

Approach:
Math

Algorithm:
1. Find the minimum element in the array.
2. Compute the sum of all elements.
3. Observe that incrementing n - 1 elements by 1 is equivalent
   to decrementing one element by 1.
4. Therefore, the minimum number of moves is:
      sum - (minimum × array length)
5. Return the computed result.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
---------------------------------------------------------
*/

class Solution {

    public int minMoves(int[] nums) {

        int minimum = nums[0];
        long sum = 0;

        for (int num : nums) {

            sum += num;

            if (num < minimum) {
                minimum = num;
            }
        }

        return (int) (sum - (long) nums.length * minimum);
    }
}