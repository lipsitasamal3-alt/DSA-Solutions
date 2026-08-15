/*
---------------------------------------------------------
Problem: Split Array Largest Sum

Platform: LeetCode

Difficulty: Hard

Approach:
Binary Search on Answer + Greedy

Algorithm:
1. Find the minimum possible answer (`low`) as the maximum
   element in the array.

2. Find the maximum possible answer (`high`) as the sum of
   all elements in the array.

3. Apply binary search between `low` and `high`.

4. For each `mid`, check whether the array can be split into
   at most `k` subarrays such that the sum of every subarray
   is at most `mid`.

5. If the array can be split:
   - `mid` is a possible answer.
   - Store it in `ans`.
   - Search for a smaller answer.

6. If the array cannot be split:
   - Increase `low` and search for a larger answer.

7. The `canSplit()` method greedily creates a new subarray
   whenever adding the current element would make the sum
   exceed `maxSum`.

8. Return the minimum possible largest subarray sum.

Time Complexity:
O(n log(sum))

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/split-array-largest-sum/
---------------------------------------------------------
*/

class Solution {

    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // Find the minimum and maximum possible answers
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;

        // Binary search on the answer
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {

                // mid is a valid answer
                ans = mid;

                // Try to find a smaller answer
                high = mid - 1;

            } else {

                // Need a larger maximum sum
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {

        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            // Start a new subarray if adding num exceeds maxSum
            if (currentSum + num > maxSum) {

                subarrays++;
                currentSum = num;

                // More than k subarrays are required
                if (subarrays > k) {
                    return false;
                }

            } else {

                currentSum += num;
            }
        }

        return true;
    }
}