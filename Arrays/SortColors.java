/*
---------------------------------------------------------
Problem: Sort Colors

Platform: LeetCode

Difficulty: Medium

Approach:
Dutch National Flag Algorithm (Three Pointers)

Algorithm:
1. Initialize three pointers:
   - low for the next position of 0.
   - mid for traversing the array.
   - high for the next position of 2.
2. Traverse the array while mid <= high.
3. If nums[mid] is 0:
   - Swap nums[low] and nums[mid].
   - Increment both low and mid.
4. If nums[mid] is 1:
   - Increment mid.
5. If nums[mid] is 2:
   - Swap nums[mid] and nums[high].
   - Decrement high.
6. Continue until the array is sorted.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/sort-colors/
---------------------------------------------------------
*/

class Solution {

    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}