/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. 
 * The result should also be sorted in ascending order. 
 * If there is a tie, the smaller elements are always preferred.
 * 
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * 
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * 
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 */

class Solution {
    
    // Time Complexity: O(log(n - k))
    public List<Integer> findClosestElementsImproved(int[] arr, int k, int x) {
        /**
         * -------- Main idea behind the binary search algorithm ----------
         * We can fully take advantage of the "sorted array", the idea is that we use binary search to minimize the range we're searching, 
         * and use the arr[mid] and arr[mid+k] to decide to move left or right
         * 
         * The binary search here is used to find the best left index rather than finding the closest element to x
         * 
         * 1) res will be a consecutive subarray of k size
         * 2) say if we need to pick 4 elements, 
         *      then we r looking at 5 elem n1, n2, n3, n4, n5
         * 
         * We need to compare two ends: 
         *      diff(x, n1) and diff(x, n5), the number with bigger diff on the end will be eleminated
         * 
         * left and right: range of all possible start of subarray with size k + 1, so we could compare both ends
         */
        int left = 0;
        int right = arr.length - k;
        
        while (left < right) {
            int mid = left + (right - left) /2;
            
            // this determines how to shift the range
            if ( Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x))  {
                // because the range can start from mid + 1 as the
                // arr[mid] is more than the arr[mid+k]
                left = mid + 1;
            } 
            else { 
                // arr[mid] - x <= arr[mid+k] - x
                // then, this range [mid, mid + k - 1] is safe comparing to  mid + k because of this comparison
                right = mid;
            }
        }

        List<Integer> list = new LinkedList<>();
        
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }

        return list;
    }

    // Time Complexity : O(n)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low >= k)
        {
            if(Math.abs(arr[low] - x) > Math.abs(x - arr[high]))
                low++;
            else
                high--;
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = low; i <= high; i++)
        {
            result.add(arr[i]);
        }
        
        return result;
    }
}