/*
---------------------------------------------------------
Problem: Permutation Sequence

Platform: LeetCode

Difficulty: Hard

Approach:
Math (Factorial Number System)

Algorithm:
1. Precompute factorials from 0! to (n-1)!.
2. Store the numbers 1 to n in a list.
3. Convert k to zero-based indexing.
4. For each position:
   - Determine the index using:
     index = k / factorial[position]
   - Append the selected number.
   - Remove it from the list.
   - Update k using the remainder.
5. Return the constructed permutation string.

Time Complexity:
O(n²)
(List removal takes O(n).)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/permutation-sequence/
---------------------------------------------------------
*/

class Solution {

    public String getPermutation(int n, int k) {

        int[] factorials = new int[n];
        factorials[0] = 1;

        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {

            int index = k / factorials[i];

            result.append(numbers.get(index));
            numbers.remove(index);

            k %= factorials[i];
        }

        return result.toString();
    }
}