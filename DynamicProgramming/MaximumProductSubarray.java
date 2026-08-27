/*
---------------------------------------------------------
Problem: Maximum Product Subarray

Platform: LeetCode

Difficulty: Medium

Approach:
Dynamic Programming + Kadane's Algorithm

Algorithm:
1. Maintain two values for the current subarray:
   - `curMax` → maximum product ending at the current index.
   - `curMin` → minimum product ending at the current index.

2. We need both maximum and minimum because multiplying
   by a negative number can turn the minimum product into
   the maximum product.

3. If the current number is negative, swap `curMax` and
   `curMin` before updating them.

4. Calculate:
   - `curMax` = maximum of the current number and
     `curMax * current number`.
   - `curMin` = minimum of the current number and
     `curMin * current number`.

5. Update `maxProduct` with the largest `curMax` found.

6. Return `maxProduct`.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/maximum-product-subarray/
---------------------------------------------------------
*/

class Solution {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];

        // Maximum and minimum product ending at current index
        int curMax = nums[0];
        int curMin = nums[0];

        // Traverse the array
        for (int i = 1; i < nums.length; i++) {

            int n = nums[i];

            // A negative number swaps the roles of
            // maximum and minimum products
            if (n < 0) {

                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            // Calculate maximum product ending here
            curMax = Math.max(n, curMax * n);

            // Calculate minimum product ending here
            curMin = Math.min(n, curMin * n);

            // Update global maximum product
            maxProduct = Math.max(maxProduct, curMax);
        }

        return maxProduct;
    }
}