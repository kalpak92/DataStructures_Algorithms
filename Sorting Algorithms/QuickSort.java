public class QuickSort
{
    private static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];

        int i = low - 1;

        for(int j = low; j < high; j++)
        {
            if(arr[j] < pivot)
            {
                i += 1;

                //swap arr[i] and arr[j]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //swap arr[i+1] and pivot
        //int temp = pivot;
        arr[high] = arr[i+1];
        arr[i+1] = pivot;

        return i+1;
    }

    private static void sort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    
    private static void print(int[] arr)
    {
        for(int i : arr)
            System.out.print(i + " ");

        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        sort(arr, 0,arr.length -1);
        print(arr);
    }
}