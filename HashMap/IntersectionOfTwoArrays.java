/*
---------------------------------------------------------
Problem: Intersection of Two Arrays

Platform: LeetCode

Difficulty: Easy

Approach:
HashSet

Algorithm:
1. Create a HashSet called `set1` and store all unique
   elements from `nums1`.

2. Create another HashSet called `intersectionSet` to store
   the common elements.

3. Traverse `nums2`.

4. For each element:
   - If it exists in `set1`, it is present in both arrays.
   - Add it to `intersectionSet`.

5. Since a HashSet stores only unique elements, duplicate
   values are automatically removed.

6. Create the result array with the size of
   `intersectionSet`.

7. Copy all elements from the HashSet into the result array.

8. Return the result.

Time Complexity:
O(n + m)

Space Complexity:
O(n + m)

Link:
https://leetcode.com/problems/intersection-of-two-arrays/
---------------------------------------------------------
*/

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        // Store unique elements from nums1
        HashSet<Integer> set1 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        // Store common unique elements
        HashSet<Integer> intersectionSet = new HashSet<>();

        // Check elements of nums2
        for (int num : nums2) {

            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        // Create result array
        int[] result = new int[intersectionSet.size()];

        int index = 0;

        // Copy intersection elements into result
        for (int num : intersectionSet) {
            result[index++] = num;
        }

        return result;
    }
}