/*
---------------------------------------------------------
Problem: Text Justification

Platform: LeetCode

Difficulty: Hard

Approach:
Greedy + String Manipulation

Algorithm:
1. Iterate through the words and group as many words
   as possible into the current line without exceeding
   maxWidth.
2. If the current line is full:
   - If there is only one word, left-justify it.
   - Otherwise, distribute spaces evenly between words.
   - Assign any extra spaces to the leftmost gaps.
3. Add the justified line to the result.
4. Process the last line:
   - Join words with a single space.
   - Pad the remaining spaces at the end.
5. Return the list of justified lines.

Time Complexity:
O(n)

Space Complexity:
O(maxWidth)

Link:
https://leetcode.com/problems/text-justification/
---------------------------------------------------------
*/

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();

        int currentLength = 0;

        for (String word : words) {

            if (currentLength + word.length() + currentLine.size() > maxWidth) {

                int gaps = currentLine.size() - 1;
                StringBuilder lineBuilder = new StringBuilder();

                if (gaps == 0) {

                    lineBuilder.append(currentLine.get(0));
                    appendSpaces(lineBuilder, maxWidth - currentLength);

                } else {

                    int totalSpaces = maxWidth - currentLength;
                    int spacePerGap = totalSpaces / gaps;
                    int extraSpaces = totalSpaces % gaps;

                    for (int i = 0; i < gaps; i++) {

                        lineBuilder.append(currentLine.get(i));

                        int spacesToApply =
                                spacePerGap + (i < extraSpaces ? 1 : 0);

                        appendSpaces(lineBuilder, spacesToApply);
                    }

                    lineBuilder.append(currentLine.get(gaps));
                }

                result.add(lineBuilder.toString());

                currentLine.clear();
                currentLength = 0;
            }

            currentLine.add(word);
            currentLength += word.length();
        }

        StringBuilder lastLineBuilder = new StringBuilder();

        for (int i = 0; i < currentLine.size(); i++) {

            lastLineBuilder.append(currentLine.get(i));

            if (i < currentLine.size() - 1) {
                lastLineBuilder.append(" ");
            }
        }

        appendSpaces(lastLineBuilder,
                maxWidth - lastLineBuilder.length());

        result.add(lastLineBuilder.toString());

        return result;
    }

    private void appendSpaces(StringBuilder sb, int count) {

        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}