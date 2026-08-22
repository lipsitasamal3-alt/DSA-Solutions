/*
---------------------------------------------------------
Problem: Maximum Subarray

Platform: LeetCode

Difficulty: Medium

Approach:
Kadane's Algorithm

Algorithm:
1. Maintain `sum` to store the sum of the current
   subarray.

2. Maintain `maxi` to store the maximum subarray sum
   found so far.

3. Traverse the array and add each element to `sum`.

4. Update `maxi` whenever `sum` becomes greater than
   the current maximum.

5. If `sum` becomes negative, reset it to 0 because a
   negative sum cannot help in forming a maximum-sum
   subarray starting at a later position.

6. Return `maxi` as the maximum subarray sum.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/maximum-subarray/
---------------------------------------------------------
*/

class Solution {

    public int maxSubArray(int[] nums) {

        long sum = 0;
        long maxi = Long.MIN_VALUE;

        // Kadane's Algorithm
        for (int i = 0; i < nums.length; i++) {

            // Add current element to the running sum
            sum += nums[i];

            // Update maximum subarray sum
            if (sum > maxi) {
                maxi = sum;
            }

            // Reset if the current sum becomes negative
            if (sum < 0) {
                sum = 0;
            }
        }

        return (int) maxi;
    }
}