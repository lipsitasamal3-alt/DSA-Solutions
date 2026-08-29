/*
---------------------------------------------------------
Problem: Contains Duplicate II

Platform: LeetCode

Difficulty: Easy

Approach:
HashMap + Sliding Window

Algorithm:
1. Create a HashMap called `seen` to store each number
   along with its most recent index.

2. Traverse the array using index `i`.

3. For every number:
   - If the number already exists in the map, calculate
     the distance between its current index and its previous
     index.
   - If the distance is less than or equal to `k`, return
     `true`.

4. Update the number's index in the HashMap with the current
   index.
   This ensures that we always compare with the most recent
   occurrence.

5. If no two equal elements are found within distance `k`,
   return `false`.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/contains-duplicate-ii/
---------------------------------------------------------
*/

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // Store each number and its most recent index
        HashMap<Integer, Integer> seen = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Check whether the number appeared before
            // and whether the index difference is <= k
            if (seen.containsKey(nums[i])
                    && i - seen.get(nums[i]) <= k) {

                return true;
            }

            // Store/update the most recent index
            seen.put(nums[i], i);
        }

        return false;
    }
}