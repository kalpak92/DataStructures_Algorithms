/**
 * You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
 * Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1] 
 */

 public class Segregate0and1
 {
     public void segregate0and1(int[] arr, int size)
     {
         int left = 0;
         int right = size - 1;

         while(left < right)
         {
             while(arr[left] == 0 && left < right)
                left++;

            while(arr[right] == 1 && left < right)
                right--;

            if(left < right)
            {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
         }
     }
    public static void main(String[] args)  
    { 
        Segregate0and1 seg = new Segregate0and1();

        int arr[] = new int[]{0, 1, 0, 1, 1, 1}; 
        int i, arr_size = arr.length; 
  
        seg.segregate0and1(arr, arr_size); 
  
        System.out.print("Array after segregation is "); 
        for (i = 0; i < 6; i++) 
            System.out.print(arr[i] + " ");
        System.out.println(); 
    } 
 }