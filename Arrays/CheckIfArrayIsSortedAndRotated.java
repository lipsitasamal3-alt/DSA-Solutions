/*
---------------------------------------------------------
Problem: Check if Array Is Sorted and Rotated

Platform: LeetCode

Difficulty: Easy

Approach:
Array Traversal + Circular Comparison

Algorithm:
1. A sorted array has no position where the current element
   is smaller than the previous element.

2. Since the array may be rotated, compare each element
   with its previous element using circular indexing.

3. Count the number of positions where:
   nums[i] < nums[(i + n - 1) % n]

4. A sorted and rotated array can have at most one such
   decreasing point.

5. If the count becomes greater than 1, the array cannot
   be sorted and rotated, so return false.

6. Otherwise, return true.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
---------------------------------------------------------
*/

class Solution {

    public boolean check(int[] nums) {

        int count = 0;
        int n = nums.length;

        // Check every element against its previous element
        // using circular indexing
        for (int i = 0; i < n; i++) {

            if (nums[i] < nums[(i + n - 1) % n]) {
                count++;
            }

            // More than one decreasing point is invalid
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}