/**
 * Today, the bookstore owner has a store open for customers.length minutes.  
 * Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
 * On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  
 * When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 * The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
 * 
 * Return the maximum number of customers that can be satisfied throughout the day.
 * Example 1:
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * 
 * Note:
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 */

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int[] window = new int[customers.length];
        int l = 0;
        int r = 0;
        int window_sum = 0;
        int max_window_sum = 0;
        int result = 0;
        
        for(int i = 0; i < customers.length; i++)
        {
            if(grumpy[i] == 0)
            {
                result += customers[i];
                window[r] = 0;
            }
            else if(grumpy[i] == 1)
            {
                System.out.print("r = " + r);
                window[r] = customers[i];
                window_sum += customers[i];
                System.out.println(" window_sum = " + window_sum);
            }
            
            // Use a sliding window win to record the number of unsatisfied customers for X minutes. 
            // Deduct the unsatisfied customers from left end of the sliding window when it is wider than X:
            if(r >= X)
            {
                System.out.println("r = " + r);
                window_sum -= window[l];
                l++;
            }
            
            max_window_sum = Math.max(max_window_sum, window_sum);
            r++;
            //System.out.println(i + " " + l + " " + r + " " + window_sum);
        }
        
        for(int i = 0; i < window.length; i++)
            System.out.print(window[i] + " ");
        System.out.println();
        
        return result + max_window_sum;
    }
}