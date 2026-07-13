/*
---------------------------------------------------------
Problem: 3Sum Closest

Platform: LeetCode

Difficulty: Medium

Approach:
Sorting + Two Pointers

Algorithm:
1. Sort the array.
2. Initialize closestSum with the sum of the first three elements.
3. Iterate through the array and fix one element.
4. Use two pointers:
   - left = i + 1
   - right = end of the array
5. Calculate the current sum of three elements.
6. If the current sum equals the target, return it.
7. Update closestSum if the current sum is closer to the target.
8. Move pointers:
   - If sum is smaller than target, increase left.
   - Otherwise, decrease right.
9. Return the closest sum found.

Time Complexity:
O(n²)

Space Complexity:
O(1) (excluding sorting space)

Link:
https://leetcode.com/problems/3sum-closest/
---------------------------------------------------------
*/

class Solution {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == target) {
                    return currentSum;
                }

                if (Math.abs(currentSum - target) < 
                    Math.abs(closestSum - target)) {

                    closestSum = currentSum;
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}