/*
---------------------------------------------------------
Problem: Merge Sorted Array

Platform: LeetCode

Difficulty: Easy

Approach:
Two Pointers (Backward Traversal)

Algorithm:
1. Initialize three pointers:
   - i at the last valid element of nums1.
   - j at the last element of nums2.
   - k at the last position of nums1.
2. Compare elements from the end of both arrays.
3. Place the larger element at index k.
4. Move the corresponding pointer backward.
5. Continue until all elements of nums2 are merged.
6. The merged sorted array is stored in nums1.

Time Complexity:
O(m + n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/merge-sorted-array/
---------------------------------------------------------
*/

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {

            if (i >= 0 && nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];
                i--;

            } else {

                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }
    }
}