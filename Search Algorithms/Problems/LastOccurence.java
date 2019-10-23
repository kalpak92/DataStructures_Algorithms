public class LastOccurence
{
    public int findLastOccurence(int[] arr, int key)
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

    public static void main(String[] args) {
        int arr[]  = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        LastOccurence obj = new LastOccurence();
        System.out.println(" Last occurrence of 8 is in : " + obj.findLastOccurence(arr, 8));
        System.out.println(" Last occurrence of 2 is in : " + obj.findLastOccurence(arr, 2));
        System.out.println(" Last occurrence of 4 is in : " + obj.findLastOccurence(arr, 4));
        System.out.println(" Last occurrence of 1 is in : " + obj.findLastOccurence(arr, 1));
    }
}