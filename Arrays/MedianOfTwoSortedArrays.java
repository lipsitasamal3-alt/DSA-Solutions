/*
---------------------------------------------------------
Problem: Median of Two Sorted Arrays

Platform: LeetCode

Difficulty: Hard

Approach:
Merge Two Sorted Arrays

Algorithm:
1. Merge both sorted arrays into a single sorted array.
2. If the total length is odd, return the middle element.
3. If the total length is even, return the average of the two middle elements.

Time Complexity: O(m + n)

Space Complexity: O(m + n)

Link:
https://leetcode.com/problems/median-of-two-sorted-arrays/
---------------------------------------------------------
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < m) {
            merged[k++] = nums1[i++];
        }

        while (j < n) {
            merged[k++] = nums2[j++];
        }

        int len = m + n;

        if (len % 2 == 1) {
            return merged[len / 2];
        }

        return (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
    }
}