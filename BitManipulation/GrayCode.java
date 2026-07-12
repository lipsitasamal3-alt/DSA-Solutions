/*
---------------------------------------------------------
Problem: Gray Code

Platform: LeetCode

Difficulty: Medium

Approach:
Bit Manipulation

Algorithm:
1. Compute the total number of Gray codes as 2ⁿ.
2. Initialize a list to store the result.
3. Iterate from 0 to (2ⁿ - 1).
4. Generate the Gray code using:
   Gray = i ^ (i >> 1)
5. Add each Gray code to the result list.
6. Return the generated sequence.

Time Complexity:
O(2ⁿ)

Space Complexity:
O(2ⁿ)

Link:
https://leetcode.com/problems/gray-code/
---------------------------------------------------------
*/

class Solution {

    public List<Integer> grayCode(int n) {

        int numElements = 1 << n;

        List<Integer> result = new ArrayList<>(numElements);

        for (int i = 0; i < numElements; i++) {

            result.add(i ^ (i >> 1));
        }

        return result;
    }
}