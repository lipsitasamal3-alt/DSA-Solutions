/*
---------------------------------------------------------
Problem: Fizz Buzz

Platform: LeetCode

Difficulty: Easy

Approach:
Simulation

Algorithm:
1. Create an empty list to store the answer.
2. Iterate from 1 to n:
   - If the number is divisible by both 3 and 5,
     add "FizzBuzz".
   - Else if it is divisible by 3,
     add "Fizz".
   - Else if it is divisible by 5,
     add "Buzz".
   - Otherwise, add the number as a string.
3. Return the completed list.

Time Complexity:
O(n)

Space Complexity:
O(1) (excluding the output list)

Link:
https://leetcode.com/problems/fizz-buzz/
---------------------------------------------------------
*/

class Solution {

    public List<String> fizzBuzz(int n) {

        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(Integer.toString(i));
            }
        }

        return answer;
    }
}