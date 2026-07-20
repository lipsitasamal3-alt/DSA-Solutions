/*
---------------------------------------------------------
Problem: Daily Temperatures

Platform: LeetCode

Difficulty: Medium

Approach:
Monotonic Stack

Algorithm:
1. Initialize an answer array and an empty stack to store indices.
2. Traverse the temperatures array from left to right.
3. While the stack is not empty and the current temperature is
   greater than the temperature at the index on the top of the stack:
   - Pop the index.
   - Calculate the number of days waited.
   - Store the result in the answer array.
4. Push the current index onto the stack.
5. Any indices left in the stack have no warmer future day, so their
   answer remains 0.
6. Return the answer array.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/daily-temperatures/
---------------------------------------------------------
*/

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];

        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {

            while (top >= 0 && temperatures[stack[top]] < temperatures[i]) {

                int previousIndex = stack[top--];
                answer[previousIndex] = i - previousIndex;
            }

            stack[++top] = i;
        }

        return answer;
    }
}