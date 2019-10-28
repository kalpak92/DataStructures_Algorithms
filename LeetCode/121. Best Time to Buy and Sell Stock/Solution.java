/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
 * Design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * 
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * 
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * 
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

 /**
  * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm.
  All the straight forward solution should work, 
  but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, it might be a little confusing.
  Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, 
  and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.

  Suppose we have original array:
    [a0, a1, a2, a3, a4, a5, a6]

    what we are given here(or we calculate ourselves) is:
    [b0, b1, b2, b3, b4, b5, b6]

    where,
    b[i] = 0, when i == 0
    b[i] = a[i] - a[i - 1], when i != 0

    suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
    then in our given array, we need to find the sum of sub array from b3 to b6.

    b3 = a3 - a2
    b4 = a4 - a3
    b5 = a5 - a4
    b6 = a6 - a5

    adding all these, all the middle terms will cancel out except two
    i.e.

    b3 + b4 + b5 + b6 = a6 - a2

    a6 - a2 is the required solution.

    so we need to find the largest sub array sum to get the most profit
  */

class Solution {
    public int maxProfit(int[] prices) {
        int currentMax = 0;
        int result = 0;
        
        for(int i = 1; i < prices.length; i++)
        {
            currentMax = Math.max(0, currentMax += prices[i] - prices[i-1]);
            result = Math.max(result, currentMax);
        }
        return result;
    }
}