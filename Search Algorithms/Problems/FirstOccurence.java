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
            //System.out.println("mid = " + mid);

            if(arr[mid] > key)
            {
                high = mid - 1;
            }
            else if (arr[mid] == key)
            {
                result = mid;
                if (mid == 0 || (arr[mid] > arr[mid - 1]))
                    break;
                //System.out.println("result = " + result);
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
                //System.out.println("low = " + low);
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