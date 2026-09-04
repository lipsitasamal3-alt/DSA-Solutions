/*
---------------------------------------------------------
Problem: Sort Characters By Frequency

Platform: LeetCode

Difficulty: Medium

Approach:
HashMap + Bucket Sort

Algorithm:
1. Use a HashMap to count the frequency of each character.
2. Create buckets where the index represents the frequency.
3. Place each character into the bucket corresponding to
   its frequency.
4. Traverse the buckets from highest frequency to lowest.
5. Append each character to the result according to its
   frequency.

Time Complexity:
O(n)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/sort-characters-by-frequency/
---------------------------------------------------------
*/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Create buckets based on frequency
        List<Character>[] buckets = new List[s.length() + 1];

        for (char c : counts.keySet()) {
            int freq = counts.get(c);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(c);
        }

        StringBuilder result = new StringBuilder();

        // Process highest frequencies first
        for (int freq = buckets.length - 1; freq >= 0; freq--) {
            if (buckets[freq] != null) {

                for (char c : buckets[freq]) {
                    for (int i = 0; i < freq; i++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }
}