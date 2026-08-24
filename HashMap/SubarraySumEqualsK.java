/*
---------------------------------------------------------
Problem: Subarray Sum Equals K

Platform: LeetCode

Difficulty: Medium

Approach:
Prefix Sum + HashMap

Algorithm:
1. Maintain `preSum` as the prefix sum of elements seen
   so far.

2. Store prefix sums and their frequencies in a HashMap.

3. Initialize the map with:
   `map.put(0, 1)`
   This handles subarrays whose sum is exactly `k`
   starting from index 0.

4. For every element:
   - Add it to `preSum`.
   - Calculate `remove = preSum - k`.

5. If `remove` exists in the map, its frequency represents
   the number of previous prefix sums that can be removed
   to obtain a subarray with sum `k`.

6. Add that frequency to `count`.

7. Store the current prefix sum in the map and increase
   its frequency.

8. Return the total count of subarrays whose sum is `k`.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/subarray-sum-equals-k/
---------------------------------------------------------
*/

class Solution {

    public int subarraySum(int[] nums, int k) {

        int n = nums.length;

        // Store prefix sums and their frequencies
        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix with sum 0
        map.put(0, 1);

        int count = 0;
        int preSum = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // Calculate current prefix sum
            preSum += nums[i];

            // Prefix sum that needs to be removed
            int remove = preSum - k;

            // Check if a previous prefix sum exists
            if (map.containsKey(remove)) {
                count += map.get(remove);
            }

            // Store current prefix sum frequency
            map.put(
                preSum,
                map.getOrDefault(preSum, 0) + 1
            );
        }

        return count;
    }
}