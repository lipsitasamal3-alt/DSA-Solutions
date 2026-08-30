/*
---------------------------------------------------------
Problem: Top K Frequent Elements

Platform: LeetCode

Difficulty: Medium

Approach:
HashMap + Bucket Sort

Algorithm:
1. Create a HashMap to store the frequency of every number
   in the array.

2. Create a bucket array where the index represents the
   frequency of a number.

3. Traverse the frequency map:
   - Get the frequency of each number.
   - Place the number inside the bucket corresponding to
     its frequency.

4. Traverse the buckets from the highest frequency to the
   lowest frequency.

5. Add numbers from each bucket to the result array until
   `k` elements have been collected.

6. Return the result array.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/top-k-frequent-elements/
---------------------------------------------------------
*/

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Store frequency of each number
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(
                num,
                countMap.getOrDefault(num, 0) + 1
            );
        }

        /*
         * Bucket index represents frequency.
         * Maximum possible frequency is nums.length.
         */
        List<Integer>[] buckets = new List[nums.length + 1];

        // Place each number into its frequency bucket
        for (int num : countMap.keySet()) {

            int frequency = countMap.get(num);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        // Traverse buckets from highest frequency to lowest
        for (int i = buckets.length - 1;
             i >= 0 && index < k;
             i--) {

            if (buckets[i] != null) {

                for (int num : buckets[i]) {

                    result[index++] = num;

                    // Stop once k elements are collected
                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}