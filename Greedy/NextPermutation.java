/*
---------------------------------------------------------
Problem: Next Permutation

Platform: LeetCode

Difficulty: Medium

Approach:
Greedy + Array Manipulation

Algorithm:
1. Traverse the array from right to left and find the first
   index `ind` such that:
   nums[ind] < nums[ind + 1]

2. If no such index exists, the array is in descending order.
   Reverse the entire array to obtain the smallest permutation.

3. Otherwise, traverse from the end of the array and find the
   first element greater than `nums[ind]`.

4. Swap `nums[ind]` with this element.

5. Reverse the portion of the array after `ind`.
   This produces the smallest possible suffix and therefore
   the next lexicographically greater permutation.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/next-permutation/
---------------------------------------------------------
*/

class Solution {

    public void nextPermutation(int[] nums) {

        int ind = -1;
        int n = nums.length;

        // Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {

            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // If no such element exists, the array is in
        // descending order. Reverse it to get the
        // smallest permutation.
        if (ind == -1) {

            reverse(nums, 0, n - 1);
            return;
        }

        // Find the smallest element greater than nums[ind]
        // from the right side
        for (int i = n - 1; i > ind; i--) {

            if (nums[i] > nums[ind]) {

                // Swap nums[ind] and nums[i]
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;

                break;
            }
        }

        // Reverse the suffix to get the next permutation
        reverse(nums, ind + 1, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {

        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}