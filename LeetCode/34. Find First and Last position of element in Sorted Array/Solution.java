/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

 class Solution 
 {
    public int[] searchRange(int[] nums, int target) 
    {
        int result[] = {-1, -1};
        
        result[0]  = findFirstOccurence(nums, target);
        result[1]  = findLastOccurence(nums, target);
        
        return result;
    }
    
    private int findFirstOccurence(int[] arr, int key)
    {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(arr[mid] > key)      // we go left
            {
                high = mid - 1;
            }
            else if (arr[mid] == key)   // there's a match but we dont know if it is the first one.
            {
                result = mid;   // update the result 
                // check if the mid element is greater than the element before it.
                // if mid is 0, then break out.
                if (mid == 0 || (arr[mid] > arr[mid - 1]))
                    break;

                // else continue going left.
                high = mid - 1;
            }
            else
            {
                // mid is less than the key to be searched. so go right.
                low = mid + 1;
            } 
        }
        return result;
    }
    
    private int findLastOccurence(int[] arr, int key)
    {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(arr[mid] > key)      // we go left
            {
                high = mid - 1;
            }
            else if (arr[mid] == key)   // there's a match but we dont know if it is the first one.
            {
                result = mid;   // update the result 
                // check if the mid element is lesser than the element after it.
                // if mid is arr.length - 1, then break out.
                if (mid == arr.length - 1 || (arr[mid] < arr[mid + 1]))
                    break;

                // else continue going right.
                low = mid + 1;
            }
            else
            {
                // mid is less than the key to be searched. so go right.
                low = mid + 1;
            } 
        }
        return result;
    }
}