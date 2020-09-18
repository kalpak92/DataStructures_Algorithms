/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> uniqueElements = new HashSet<>();
        List<Integer> common = new ArrayList<>();
        
        for(int i : nums1) {
            uniqueElements.add(i);
        }
        
        for(int i : nums2) {
            if(uniqueElements.contains(i)) {
                if(!common.contains(i))
                    common.add(i);
            }
        }
        
        int[] result = new int[common.size()];
        int idx = 0;
        for(int i : common) {
            result[idx++] = i;
        }
        return result;
    }
}