/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.
 * 
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class SolutionUsingQuickSelect {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int result = Integer.MIN_VALUE;
        
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot == k - 1) {
                result = nums[pivot];
                break;
            }
            
            if (pivot < k - 1) {        // go right
                left = pivot + 1;
            } 
            else {
                right = pivot - 1;      // go left
            }
        }
        return result;
    }
    
    private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
        
		for(int j = low; j < high; j++) {
			if(arr[j] > pivot) {
				i = i + 1;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
        
		arr[high] = arr[i+1];
		arr[i+1] = pivot;
        
		return i+1;
    }
}