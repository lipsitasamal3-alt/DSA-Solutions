/*
---------------------------------------------------------
Problem: Adding Two Negabinary Numbers

Platform: LeetCode

Difficulty: Medium

Approach:
Simulation

Algorithm:
1. Initialize two pointers at the end of both arrays and a carry
   value of 0.
2. While there are remaining digits in either array or the carry
   is non-zero:
   - Add the current digits (if any) to the carry.
   - Append the least significant bit of the sum
     (`carry & 1`) to the result.
   - Update the carry using negabinary arithmetic:
       carry = -(carry >> 1)
3. Remove leading zeros from the result, keeping at least one
   digit.
4. Reverse the result since it was built from least significant
   to most significant bit.
5. Convert the list into an array and return it.

Time Complexity:
O(max(n, m))

Space Complexity:
O(max(n, m))

Link:
https://leetcode.com/problems/adding-two-negabinary-numbers/
---------------------------------------------------------
*/

class Solution {

    public int[] addNegabinary(int[] arr1, int[] arr2) {

        List<Integer> result = new ArrayList<>();

        int carry = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;

        while (i >= 0 || j >= 0 || carry != 0) {

            if (i >= 0) {
                carry += arr1[i];
                i--;
            }

            if (j >= 0) {
                carry += arr2[j];
                j--;
            }

            result.add(carry & 1);
            carry = -(carry >> 1);
        }

        while (result.size() > 1 && result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        Collections.reverse(result);

        int[] output = new int[result.size()];

        for (int k = 0; k < result.size(); k++) {
            output[k] = result.get(k);
        }

        return output;
    }
}