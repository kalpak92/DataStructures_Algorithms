/**
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 * The i-th package on the conveyor belt has a weight of weights[i].  
 * Each day, we load the ship with packages on the conveyor belt (in the order given by weights). 
 * We may not load more weight than the maximum weight capacity of the ship.
 * 
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
 * 
 * Example 1:
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * 
 * Explanation: 
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts 
 * like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed. 
 * 
 * Example 2:
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation: 
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * 
 * Example 3:
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation: 
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * 
 * Constraints:
 *     1 <= D <= weights.length <= 50000
 *     1 <= weights[i] <= 500
 */


class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // The key is left = max(weights), right = sum(weights),
        // which are the minimum and maximum possible weight capacity of the ship.
        int left = 0;
        int right = 0;
        for(int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        
        // Binary Search to find the minimum weight capacity of the ship between left and right.
        while(left < right) {
            int currentCapacity = left + (right - left)/2;
            int requiredDays = calculateDaysRequired(weights, currentCapacity);
            
            // If requiredDays > D, it means the current ship is too small, we modify left = mid + 1 and continue
            // If all the cargo is successfully put into ships, we might have a chance to find a smaller ship, so let right = mid and continue.
            if(requiredDays > D) {
                left = currentCapacity + 1;
            }
            else {
                right = currentCapacity;
            }
        }
        return left;
    }
    
    private int calculateDaysRequired(int[] weights, int maximumCapacity) {
        int capacity = 0;
        int requiredDays = 1;
        
        // Start putting the cargo into ship in order.
        for(int w : weights) {
            capacity += w;
            if(capacity > maximumCapacity) {
                requiredDays++;
                capacity = w;
            }
        }
        return requiredDays;
    }
}