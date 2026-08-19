/*
---------------------------------------------------------
Problem: Remove Element

Platform: LeetCode

Difficulty: Easy

Approach:
Two Pointers

Algorithm:
1. Use `k` to keep track of the position where the next
   valid element should be placed.

2. Traverse the array from left to right.

3. If `nums[i]` is not equal to `val`, copy it to
   `nums[k]` and increment `k`.

4. Elements equal to `val` are skipped.

5. After traversal, the first `k` positions contain all
   elements that are not equal to `val`.

6. Return `k`, which represents the new length of the array.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/remove-element/
---------------------------------------------------------
*/

class Solution {

    public int removeElement(int[] nums, int val) {

        int k = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Keep elements that are not equal to val
            if (nums[i] != val) {

                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}