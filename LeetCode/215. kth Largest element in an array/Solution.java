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

class Solution {

	public int findKthLargestII(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for(int i : nums)
        {
            heap.add(i);
            if(heap.size() > k)
                heap.poll();
        }
        
        return heap.poll();
	}
	
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, k - 1);
	}
	
    private int select(int[] arr, int low, int high, int k)
	{
		int pivot = partition(arr, low, high);
		
		if (pivot == k)
			return arr[pivot];
		else
		{
			if (pivot > k)
				return select(arr, low, pivot - 1, k);
			else
				return select(arr, pivot + 1, high, k);
		}
        
    }
    
    private int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];
		int i = low - 1;
		for(int j = low; j < high; j++)
		{
			if(arr[j] > pivot)
			{
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