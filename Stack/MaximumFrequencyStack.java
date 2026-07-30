/*
---------------------------------------------------------
Problem: Maximum Frequency Stack

Platform: LeetCode

Difficulty: Hard

Approach:
HashMap + Stack

Algorithm:
1. Maintain:
   - A frequency map to store the frequency of each value.
   - A group map where each frequency maps to a stack of values.
   - A variable to track the current maximum frequency.
2. For push(val):
   - Increase the frequency of the value.
   - Update the maximum frequency if needed.
   - Push the value onto the stack corresponding to its frequency.
3. For pop():
   - Pop the most recently added value from the stack of the
     maximum frequency.
   - Decrease its frequency.
   - If the current maximum-frequency stack becomes empty,
     decrease the maximum frequency.
4. Return the popped value.

Time Complexity:
Push: O(1)
Pop: O(1)

Space Complexity:
O(n)

Link:
https://leetcode.com/problems/maximum-frequency-stack/
---------------------------------------------------------
*/

class FreqStack {

    private HashMap<Integer, Integer> frequencyMap;
    private HashMap<Integer, Stack<Integer>> groupMap;
    private int maximumFrequency;

    public FreqStack() {

        frequencyMap = new HashMap<>();
        groupMap = new HashMap<>();
        maximumFrequency = 0;
    }

    public void push(int val) {

        int frequency = frequencyMap.getOrDefault(val, 0) + 1;
        frequencyMap.put(val, frequency);

        if (frequency > maximumFrequency) {
            maximumFrequency = frequency;
        }

        groupMap.putIfAbsent(frequency, new Stack<>());
        groupMap.get(frequency).push(val);
    }

    public int pop() {

        int value = groupMap.get(maximumFrequency).pop();

        frequencyMap.put(value, frequencyMap.get(value) - 1);

        if (groupMap.get(maximumFrequency).isEmpty()) {
            maximumFrequency--;
        }

        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */