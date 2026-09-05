/*
---------------------------------------------------------
Problem: Next Greater Element I

Platform: LeetCode

Difficulty: Easy

Approach:
Monotonic Stack + HashMap

Algorithm:
1. Traverse `nums2` from left to right.
2. Maintain a stack of elements whose next greater
   element has not been found yet.
3. When the current number is greater than the stack's
   top, it is the next greater element for that number.
4. Store the mapping in a HashMap.
5. Push the current number onto the stack.
6. For each element in `nums1`, retrieve its next greater
   element from the HashMap.
7. Return -1 if no greater element exists.

Time Complexity:
O(n + m)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/next-greater-element-i/
---------------------------------------------------------
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Find next greater elements in nums2
        for (int num : nums2) {

            // Resolve elements smaller than the current number
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        int[] ans = new int[nums1.length];

        // Build the answer for nums1
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}