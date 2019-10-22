public class FirstOccurence
{
    public int findFirstOccurence(int[] arr, int key)
    {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while(low < high)
        {
            int mid = low + (high - low)/2;

            if(arr[mid] > key)      // we go left
            {
                high = mid - 1;
            }
            else if (arr[mid] == key)   // there's a match but we dont know if it is the first one.
            {
                result = mid;   // update the result and 
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

    public static void main(String[] args) {
        int arr[]  = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        FirstOccurence obj = new FirstOccurence();
        System.out.println(obj.findFirstOccurence(arr, 1));
    }
}