/*
---------------------------------------------------------
Problem: Baseball Game

Platform: LeetCode

Difficulty: Easy

Approach:
Stack

Algorithm:
1. Initialize a stack to store valid scores.
2. Traverse each operation:
   - If "+":
     - Add the sum of the previous two scores.
   - If "D":
     - Add double the previous score.
   - If "C":
     - Remove the previous score.
   - Otherwise:
     - Convert the string to an integer and add it.
3. Sum all values remaining in the stack.
4. Return the total score.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/baseball-game/
---------------------------------------------------------
*/

class Solution {

    public int calPoints(String[] operations) {

        List<Integer> stack = new ArrayList<>();

        for (String op : operations) {

            int size = stack.size();

            switch (op) {

                case "+":
                    stack.add(stack.get(size - 1) + stack.get(size - 2));
                    break;

                case "D":
                    stack.add(stack.get(size - 1) * 2);
                    break;

                case "C":
                    stack.remove(size - 1);
                    break;

                default:
                    stack.add(Integer.parseInt(op));
                    break;
            }
        }

        int totalSum = 0;

        for (int score : stack) {
            totalSum += score;
        }

        return totalSum;
    }
}