public class BinarySearch
{
    public int binarySearchIterative(int[] arr, int data)
    {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == data)
                return mid;
                
            else if (arr[mid] < data)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public int binarySearchRecursive(int[] arr, int low, int high, int data)
    {
        int mid = low + (high - low)/2;

        if(low > high)
            return -1;
        
        if (arr[mid] == data)
            return mid;
        
        else if (arr[mid] < data)
            return binarySearchRecursive(arr, mid + 1, high, data);
        else 
            return binarySearchRecursive(arr, low, mid - 1, data);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        BinarySearch obj = new BinarySearch();

        System.out.println(obj.binarySearchIterative(arr, 8));
        System.out.println(obj.binarySearchRecursive(arr, 0, arr.length - 1, 2));
    }
}