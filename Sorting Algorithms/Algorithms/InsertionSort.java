public class InsertionSort
{
    public static void sort(int[] arr)
    {
        for(int j = 1; j < arr.length; j++)
        {
            int key = arr[j];
            int i = j - 1;

            while(i >= 0 && arr[i] > key)
            {
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i+1] = key;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 2, 4, 6, 1, 3};
        sort(arr);

        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}