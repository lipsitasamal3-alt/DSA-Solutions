/*
---------------------------------------------------------
Problem: Intersection of Two Arrays II

Platform: LeetCode

Difficulty: Easy

Approach:
HashMap + Frequency Counting

Algorithm:
1. Create a HashMap to store the frequency of each number
   in `nums1`.

2. Traverse `nums2` and check whether the current number
   exists in the map with a frequency greater than 0.

3. If it exists:
   - Add the number to the result list.
   - Decrease its frequency in the map.

4. This ensures that each number is added only as many times
   as it appears in both arrays.

5. Convert the result list into an integer array.

6. Return the result array.

Time Complexity:
O(n + m)

Space Complexity:
O(min(n, m))

Link:
https://leetcode.com/problems/intersection-of-two-arrays-ii/
---------------------------------------------------------
*/

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        // Store frequency of elements in nums1
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {

            map.put(
                num,
                map.getOrDefault(num, 0) + 1
            );
        }

        // Store intersection elements
        List<Integer> resultList = new ArrayList<>();

        // Traverse nums2
        for (int num : nums2) {

            // Check if the number is still available
            // in nums1
            if (map.containsKey(num) && map.get(num) > 0) {

                resultList.add(num);

                // Use one occurrence
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert ArrayList to int[]
        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}