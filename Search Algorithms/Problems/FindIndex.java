/**
 * Given a sorted array consisting 0’s and 1’s. The problem is to find the index of first ‘1’ in the sorted array. 
 * It could be possible that the array consists of only 0’s or only 1’s. If 1’s are not present in the array then print “-1”.
 * 
 * Examples :
 * Input : arr[] = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1}
 * Output : 6
 * The index of first 1 in the array is 6.
 * 
 * Input : arr[] = {0, 0, 0, 0}
 * Output : -1
 * 1's are not present in the array.
 */

public class FindIndex
{
    public int indexOfFirstOne(int[] arr)
    {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0))
                return mid;

            else if (arr[mid] == 1)
                high = mid - 1;         // go left
            else 
                low = mid + 1;          // go right
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 };
        int arr1[] = { 0, 0, 0, 0, 0, 0};
        int arr2[] = { 0, 0, 0, 0, 0, 0, 1 };

        FindIndex obj = new FindIndex();
        System.out.println("The index of the first one is: " + obj.indexOfFirstOne(arr));
        System.out.println("The index of the first one is: " + obj.indexOfFirstOne(arr1));
        System.out.println("The index of the first one is: " + obj.indexOfFirstOne(arr2));
    }
}