/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
 * If it does not exist, output -1 for this number.
 * 
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * 
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * 
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * 
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * 
 */

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // The approach is such that we built a monotonically decreasing stack based on nums2.
        // As we pop out from the stack, we put the elements in a map to keep track and for faster lookup.
        // Traverse through nums1 array and look for the correspongding NGE in the map. If not present, substitute it with -1.
        
        Deque<Integer> decreasingStack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        
        for(int i = 0; i < nums2.length; i++) {
            while(!decreasingStack.isEmpty() && decreasingStack.peek() < nums2[i]) {
                map.put(decreasingStack.pop(), nums2[i]);
            }    
            decreasingStack.push(nums2[i]);
        }
        
        for(int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
