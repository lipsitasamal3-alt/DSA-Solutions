/*
---------------------------------------------------------
Problem: Remove Duplicates from Sorted Array

Platform: LeetCode

Difficulty: Easy

Approach:
Two Pointers

Algorithm:
1. Handle the empty array case.
2. Use two pointers:
   - slow points to the last unique element.
   - fast scans the array.
3. Whenever a new unique element is found, move the slow pointer
   and copy the element.
4. Return the count of unique elements.

Time Complexity: O(n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
---------------------------------------------------------
*/

class Solution {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {

            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}