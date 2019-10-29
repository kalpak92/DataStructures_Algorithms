/**
 * Given an array of integers of size 'n'.
 * Calculate the maximum sum possible for 'k' consecutive elements in the array.
 */

public class MaxPossibleSum
{
    public int maxSumNaive(int[] arr, int k)
    {
        int maxSum = 0;
        for (int i = 0; i < arr.length - k + 1; i++)
        {
            int current_sum = 0;

            for(int j = 0; j < k; j++)
            {
                current_sum += arr[i + j];
            }
            maxSum = Math.max(current_sum, maxSum);
        }
        return maxSum;
    }

    public int maxSumSlidingWindow(int[] arr, int k)
    {
        // calculate the 1st window
        int window_sum = 0;
        for(int i = 0; i < k; i++)
            window_sum += arr[i];

        int maxSum = window_sum;
        // check for subsequent windows
        for(int i = k; i< arr.length; i++)
        {
            window_sum += arr[i] - arr[i-k];        // slide the window by adding one from the right and removing one from the left
            maxSum = Math.max(window_sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {100, 200, 300, 400, 500};

        MaxPossibleSum obj = new MaxPossibleSum();
        System.out.println(obj.maxSumNaive(arr, 2));

        int arr2[] = {100, 200, 100, 400, 500, 2, 600};
        System.out.println(obj.maxSumSlidingWindow(arr2, 2));

    }
}