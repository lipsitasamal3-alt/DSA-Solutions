/*
---------------------------------------------------------
Problem: Contains Duplicate

Platform: LeetCode

Difficulty: Easy

Approach:
HashSet

Algorithm:
1. Create a HashSet called `seen` to store numbers that
   have already appeared.

2. Traverse the array using a for-each loop.

3. For each number:
   - If it already exists in the HashSet, a duplicate has
     been found, so return `true`.
   - Otherwise, add it to the HashSet.

4. If the entire array is traversed without finding a
   duplicate, return `false`.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/contains-duplicate/
---------------------------------------------------------
*/

class Solution {

    public boolean containsDuplicate(int[] nums) {

        // Store numbers that have already been seen
        HashSet<Integer> seen = new HashSet<>();

        // Traverse the array
        for (int num : nums) {

            // Duplicate found
            if (seen.contains(num)) {
                return true;
            }

            // Store the current number
            seen.add(num);
        }

        // No duplicate found
        return false;
    }
}