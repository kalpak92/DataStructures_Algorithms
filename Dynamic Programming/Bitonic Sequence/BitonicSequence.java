/**
 * A sequence of numbers is called a bitonic sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. 
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 */

 public class BitonicSequence
 {
     public int getMaxLenBitonicSeq(int[] arr)
     {
        int[] lis = new int[arr.length];
        int[] lds = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            lis[i] = 1;
            lds[i] = 1;
        }

        for(int i = 1; i < arr.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr[j] < arr[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }

        for(int i = arr.length - 2; i >= 0; i--)
        {
            for(int j = arr.length - 1; j > i; j--)
            {
                if(arr[i] > arr[j])
                    lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }

        int max = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(max < lis[i] + lds[i] - 1)
                max = lis[i] + lds[i] - 1;
        }

        return max;
     }

     public static void main(String[] args)
     {
         BitonicSequence bs = new BitonicSequence();
         int[] arr = {1,4,3,7,2,1,8,11,13,0};
         int[] arr2 = {1,7,4,9,2,5};
         System.out.println(bs.getMaxLenBitonicSeq(arr2));
     }
 }