/*
---------------------------------------------------------
Problem: Move Zeroes

Platform: LeetCode

Difficulty: Easy

Approach:
Two Pointers

Algorithm:
1. Find the position of the first zero and store it in `j`.

2. If there is no zero in the array, return immediately.

3. Start traversing from the position after `j`.

4. Whenever a non-zero element is found:
   - Swap it with the zero at position `j`.
   - Move `j` forward.

5. This places all non-zero elements at the beginning
   while maintaining their original relative order.

6. All zeroes are automatically moved to the end.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/move-zeroes/
---------------------------------------------------------
*/

class Solution {

    public void moveZeroes(int[] nums) {

        int j = -1;

        // Find the first zero
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // No zero exists
        if (j == -1) {
            return;
        }

        // Move non-zero elements forward
        for (int i = j + 1; i < nums.length; i++) {

            if (nums[i] != 0) {

                // Swap non-zero element with zero
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}