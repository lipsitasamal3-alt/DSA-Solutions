/*
---------------------------------------------------------
Problem: Palindrome Number

Platform: LeetCode

Difficulty: Easy

Approach:
Reverse Half of the Number

Algorithm:
1. Negative numbers are not palindromes.
2. Numbers ending with 0 (except 0 itself) cannot be palindromes.
3. Reverse only the second half of the number.
4. Compare the first half with the reversed second half.
5. For odd-length numbers, ignore the middle digit.

Time Complexity: O(log₁₀ n)

Space Complexity: O(1)

Link:
https://leetcode.com/problems/palindrome-number/
---------------------------------------------------------
*/

class Solution {

    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}