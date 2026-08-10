/*
---------------------------------------------------------
Problem: Product of Array Except Self

Platform: LeetCode

Difficulty: Medium

Approach:
Arrays + Prefix/Suffix Products

Algorithm:
1. `answer[i]` initially stores the product of all elements
   to the LEFT of index i.

2. Traverse from left to right:
      answer[i] = answer[i - 1] * nums[i - 1]

3. Maintain `suffixProduct`, which stores the product of all
   elements to the RIGHT of the current index.

4. Traverse from right to left:
      answer[i] *= suffixProduct

   Then update:
      suffixProduct *= nums[i]

5. This gives the product of every element except nums[i].

Example:
nums = [1, 2, 3, 4]

After prefix:
[1, 1, 2, 6]

After suffix:
[24, 12, 8, 6]

Time Complexity:
O(n)

Space Complexity:
O(1) extra space
(excluding the output array)

Link:
https://leetcode.com/problems/product-of-array-except-self/
---------------------------------------------------------
*/

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        // Prefix products
        answer[0] = 1;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Suffix products
        int suffixProduct = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] *= suffixProduct;

            suffixProduct *= nums[i];
        }

        return answer;
    }
}