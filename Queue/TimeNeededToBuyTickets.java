/*
---------------------------------------------------------
Problem: Time Needed to Buy Tickets

Platform: LeetCode

Difficulty: Easy

Approach:
Simulation + Math

Algorithm:
1. Let targetTickets be the number of tickets required by person k.
2. Traverse the tickets array.
3. For each person:
   - If the person's index is less than or equal to k:
     - They can buy at most targetTickets tickets.
   - Otherwise:
     - They can buy at most targetTickets - 1 tickets because
       person k finishes before their last turn.
4. Add the minimum of the person's tickets and the allowed tickets
   to the total time.
5. Return the total time.

Time Complexity:
O(n)

Space Complexity:
O(1)

Link:
https://leetcode.com/problems/time-needed-to-buy-tickets/
---------------------------------------------------------
*/

class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0;
        int targetTickets = tickets[k];

        for (int i = 0; i < tickets.length; i++) {

            if (i <= k) {
                time += Math.min(tickets[i], targetTickets);
            } else {
                time += Math.min(tickets[i], targetTickets - 1);
            }
        }

        return time;
    }
}