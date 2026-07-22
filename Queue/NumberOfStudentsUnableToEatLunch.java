/*
---------------------------------------------------------
Problem: Number of Students Unable to Eat Lunch

Platform: LeetCode

Difficulty: Easy

Approach:
Counting

Algorithm:
1. Count the number of students who prefer circular (0) and square (1) sandwiches.
2. Traverse the sandwiches array from top to bottom.
3. For each sandwich:
   - If no student prefers that type, stop the process.
   - Otherwise, decrement the count of students preferring that sandwich.
4. The remaining students are unable to eat.
5. Return the sum of the remaining preference counts.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
---------------------------------------------------------
*/

class Solution {

    public int countStudents(int[] students, int[] sandwiches) {

        int[] counts = new int[2];

        for (int student : students) {
            counts[student]++;
        }

        for (int sandwich : sandwiches) {

            if (counts[sandwich] == 0) {
                break;
            }

            counts[sandwich]--;
        }

        return counts[0] + counts[1];
    }
}