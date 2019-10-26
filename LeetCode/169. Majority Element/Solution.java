/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

class Solution {

    // using boyer moore's voting algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;
        
        for(int num: nums)
        {
            if(count == 0)
                candidate = num;
            
            count+= (num == candidate) ? 1 : -1;
        }
        
        return candidate;
    }

    /**
     * If the elements are sorted in monotonically increasing (or decreasing) order, 
     * the majority element can be found at index (n/2) and (n/2 +1) when n is even.
     */
    public int majorityElementII(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * We know that the majority element occurs more than floor(n / 2) times, and a HashMap allows us to count element occurrences efficiently.
     */

    public int majorityElementIII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int res = 0;
        
        for (int num: nums) 
        {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length/2) 
            {
                res = num;
                break;
            }
        }
        return res;
    }
}