/*
---------------------------------------------------------
Problem: 3Sum

Platform: LeetCode

Difficulty: Medium

Approach:
Sorting + HashSet

Algorithm:
1. Sort the array.
2. Fix one element at a time.
3. Use a HashSet to find the third element that completes the triplet.
4. Store unique triplets in a Set to avoid duplicates.
5. Return the result as a list.

Time Complexity: O(n²)

Space Complexity: O(n)

Link:
https://leetcode.com/problems/3sum/
---------------------------------------------------------
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            HashSet<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);

                if (seen.contains(target)) {
                    result.add(Arrays.asList(nums[i], target, nums[j]));
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}