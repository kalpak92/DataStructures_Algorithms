/**
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  
 * The guards have gone and will come back in H hours.
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  
 * If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * 
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * 
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * 
 * Example 1:
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * 
 * Example 2:
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * 
 * Example 3:
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * 
 * Constraints:
 * 
 *     1 <= piles.length <= 10^4
 *     piles.length <= H <= 10^9
 *     1 <= piles[i] <= 10^9
 */

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        
        // Lower bound of the search space is 1 
        // Upper bound is max(piles) 
        // Because Koko can only choose one pile of bananas to eat every hour.
        
        int left = 1;
        int right = 0;
        for(int p : piles) {
            right = Math.max(right, p);
        }
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(canEatBananas(piles, mid, H))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    
    private boolean canEatBananas(int[] piles, int speed, int H) {
        int hoursTaken = 0;
        
        for(int p : piles) {
            hoursTaken += p/speed;
            if(p % speed != 0)  // take the ceiling value
                hoursTaken++;
        }
        // return true if all the bananas can be eaten within the given hour
        return (hoursTaken <= H);
    }
}