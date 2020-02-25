/**
 * Given an array of n integers. 
 * The task is to remove or delete the minimum number of elements from the array so that when the remaining elements are placed in the same sequence order to form an increasing sorted sequence.
 * 
 * Examples :
 * Input : {5, 6, 1, 7, 4}
 * Output : 2
 * Removing 1 and 4 leaves the remaining sequence order as 5 6 7 which is a sorted sequence.
 * 
 * Input : {30, 40, 2, 5, 1, 7, 45, 50, 8}
 * Output : 4
 */

 /**
  * Algorithm:
  *     -->arr be the given array.
  *     -->n number of elements in arr.
  *     -->len be the length of longest
  *     increasing subsequence in arr.
  * 
  *     -->// minimum number of deletions
  *         min = n - len
  */

    import java.util.*;

  public class MinDelSortedSeq
  {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int[] maxLength = new int[nums.length];
        Arrays.fill(maxLength, 1);
        
        int maxSoFar = 1;
       
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }
            //System.out.println(maxLength[i]);
            maxSoFar = Math.max(maxSoFar, maxLength[i]);
        }
        //System.out.println(maxLength);
        return maxSoFar;
    }

    public void minDeletionToSortedSequence(int[] arr)
    {
        System.out.println("The minimum number of deletions to make a sorted sequence : " + (arr.length - lengthOfLIS(arr)));
    }

    public static void main(String[] args)
    {
        int arr[] = {30, 40, 2, 5, 1, 7, 45, 50, 8}; 
        MinDelSortedSeq obj = new MinDelSortedSeq();
        obj.minDeletionToSortedSequence(arr);
    }
  }