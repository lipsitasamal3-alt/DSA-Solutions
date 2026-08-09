/*
---------------------------------------------------------
Problem: Simplified Fractions

Platform: LeetCode

Difficulty: Medium

Approach:
Math + GCD

Algorithm:
1. Consider every denominator from 2 to n.
2. For each denominator, consider every numerator from 1 to
   denominator - 1.
3. A fraction is already simplified when:
      gcd(numerator, denominator) == 1
4. Add the valid fraction as a string.
5. Return the list.

Why GCD?
Two numbers have no common factor other than 1 exactly when
their GCD is 1.

Time Complexity:
O(n² log n)

Space Complexity:
O(1), excluding the output list.

Link:
https://leetcode.com/problems/simplified-fractions/
---------------------------------------------------------
*/

class Solution {

    public List<String> simplifiedFractions(int n) {

        List<String> result = new ArrayList<>();

        for (int denominator = 2; denominator <= n; denominator++) {

            for (int numerator = 1; numerator < denominator; numerator++) {

                if (gcd(numerator, denominator) == 1) {
                    result.add(numerator + "/" + denominator);
                }
            }
        }

        return result;
    }

    private int gcd(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}