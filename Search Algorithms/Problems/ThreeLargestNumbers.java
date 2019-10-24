/**
 * Write a function that takes in an array of integers and returns a sorted array
 * of the three largest integers in the input array.
 * 
 * Note that the function should return duplicate integers if necessary.
 * For example: it should return [10, 10, 12] for an input array of [10, 5, 9, 10, 12].
 * 
 * Sample input: [141,1,17,-7,-17, -27, 18, 541, 8, 7, 7]
 * Sample output: [18, 141, 541]
 */

class ThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {       
          int[] result = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
          
          for (int i : array)
              updateLargest(i, result);
          
          return result;
    }
      
      private static void updateLargest(int num, int[] result)
      {
          if( num > result[2]){
              result[0] = result[1];
              result[1] = result[2];
              result[2] = num;
          }
          else if (num > result[1])
          {
              result[0] = result[1];
              result[1] = num;
          }
          else if (num > result[0])
          {
              result[0] = num;
          }
      }
      
      private static void print(int[] arr)
      {
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();
      }
      public static void main(String[] args) {
        int arr[] = {12, 13, 1, 10, 34, 16};
        int arr1[] = {7, 7, 8}; 

        print(findThreeLargestNumbers(arr));
        print(findThreeLargestNumbers(arr1));
        
      }

  }