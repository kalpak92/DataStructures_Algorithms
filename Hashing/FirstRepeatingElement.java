/**
 * Given an array of n numbers, give an algorithm for finding the first element in the array which is repeated. 
 * For example, in the array A = {3,2,1,2,2,3}, the first repeated number is 3 (not 2). 
 * That means, we need to return the first element among the repeated elements.
 */
import java.util.HashSet;

public class FirstRepeatingElement
{
    public int getFirstRepeat(int arr[])
    {
        HashSet<Integer> map = new HashSet<>();
        int index  = -1;
        int len = arr.length;

        for(int i = len - 1; i >= 0; i --)
        {
            if(map.contains(arr[i]))
                index = i;
            else
                map.add(arr[i]);
        }

        return arr[index];
    }

    public static void main(String[] args) {
        FirstRepeatingElement obj = new FirstRepeatingElement();
        int arr[] = {3,2,1,2,2,3};

        System.out.println("The first repeating element is : " + obj.getFirstRepeat(arr));
    }
}