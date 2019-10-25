public class QuickSelect
{
    public static void main(String[] args) 
    {
        int[] array = {10, 4, 5, 8, 6, 11, 26}; 
        int k = 3;
        print(array);
        System.out.println("k = " + k + " smallest element is: " + quickSort(array, 0, array.length - 1, k - 1));
    }
	
	private static int quickSort(int[] arr, int low, int high, int k)
	{
		int pivot = partition(arr, low, high);
		
		if (pivot == k)
			return arr[pivot];
		else
		{
			if (pivot > k)
				return quickSort(arr, low, pivot - 1, k);
			else
				return quickSort(arr, pivot + 1, high, k);
		}
	}
	
	private static int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];
		int i = low - 1;
		for(int j = low; j < high; j++)
		{
			if(arr[j] < pivot)
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
    
    private static void print(int[] arr)
    {
        System.out.print("The array is : ");
        for(int i : arr)
            System.out.print(i + " ");

        System.out.println();
    }
}