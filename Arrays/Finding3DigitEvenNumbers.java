/*
---------------------------------------------------------
Problem: Finding 3-Digit Even Numbers

Platform: LeetCode

Difficulty: Easy

Approach:
Array Frequency Counting

Algorithm:
1. Count the frequency of each digit (0–9) in the input array.
2. Iterate through all three-digit even numbers (100 to 998).
3. For each number:
   - Extract its hundreds, tens, and ones digits.
   - Count the required frequency of each digit.
4. Compare the required frequencies with the available frequencies.
5. If all required digits are available, add the number to the result.
6. Convert the result list to an array and return it.

Time Complexity:
O(1)
(Only 450 even numbers are checked.)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/finding-3-digit-even-numbers/
---------------------------------------------------------
*/

class Solution {

    public int[] findEvenNumbers(int[] digits) {

        int[] availableCounts = new int[10];

        for (int d : digits) {
            availableCounts[d]++;
        }

        List<Integer> resultList = new ArrayList<>();

        for (int num = 100; num < 1000; num += 2) {

            int d1 = num / 100;
            int d2 = (num / 10) % 10;
            int d3 = num % 10;

            int[] requiredCounts = new int[10];

            requiredCounts[d1]++;
            requiredCounts[d2]++;
            requiredCounts[d3]++;

            if (availableCounts[d1] >= requiredCounts[d1] &&
                availableCounts[d2] >= requiredCounts[d2] &&
                availableCounts[d3] >= requiredCounts[d3]) {

                resultList.add(num);
            }
        }

        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}