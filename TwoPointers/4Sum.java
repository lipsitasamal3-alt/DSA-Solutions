/*
---------------------------------------------------------
Problem: 4Sum

Platform: LeetCode

Difficulty: Medium

Approach:
Sorting + Two Pointers

Algorithm:
1. Handle the edge case where the array has fewer than
   four elements.
2. Sort the array.
3. Fix the first two elements using nested loops.
4. Skip duplicate values for both fixed elements.
5. Use two pointers:
   - left = j + 1
   - right = end of the array
6. Calculate the sum of the four numbers.
7. If the sum equals the target:
   - Add the quadruplet to the result.
   - Skip duplicate values.
   - Move both pointers.
8. If the sum is less than the target:
   - Move the left pointer.
9. Otherwise:
   - Move the right pointer.
10. Return all unique quadruplets.

Time Complexity:
O(n³)

Space Complexity:
O(1) (excluding the output list)

Link:
https://leetcode.com/problems/4sum/
---------------------------------------------------------
*/

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long currentSum =
                            (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (currentSum == target) {

                        result.add(Arrays.asList(
                                nums[i], nums[j], nums[left], nums[right]
                        ));

                        while (left < right &&
                               nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right &&
                               nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;

                    } else if (currentSum < target) {

                        left++;

                    } else {

                        right--;
                    }
                }
            }
        }

        return result;
    }
}