/**
 * An Array of integers is given, both +ve and -ve. 
 * You need to find the two elements such that their sum is closest to zero.
 */

import java.util.*;
import java.lang.*;
public class SumClosestToZero
{
    public void twoSumCloseToZero(int[] arr)
    {
        int i = 0;
        int n = arr.length;
        int j = n - 1;
        int sum = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        int min_l = i;
        int min_r = n - 1;
        
        Arrays.sort(arr);

        while(i < j)
        {
            sum = arr[i] + arr[j];
            if(Math.abs(sum) < Math.abs(minSum))
            {
                minSum = sum;
                min_l = i;
                min_r = j;
            }
            if (sum < 0)
                i++;
            else
                j--;            
        }

        System.out.println("The two elements whose sum is minimum are : " + arr[min_l] + " " + arr[min_r]);
    }

    public static void main(String[] args) {
        SumClosestToZero obj  = new SumClosestToZero();
        int arr[] = {1, 60, -10, 70, -80, 85};

        obj.twoSumCloseToZero(arr);
    }
}