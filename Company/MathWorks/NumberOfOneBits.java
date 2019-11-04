/**
 * Given an integer 'n', we want to know the following:
 * 1. How many 1-bits are in its binary representation?
 * 2. What are the respective positions of each 1-bit, in ascending order?
 * 
 * For Example: n = 37.
 * 
 *  Binary Representation is 100101
 *  So the 1-bits are located at 1st, 4th and 6th positions.
 * 
 * Output:
 * 3 1 4 6
 * 
 */
import java.util.*;

public class NumberOfOneBits {

    public static List<Integer> getOneCount(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int index = 1;
        while (n != 0) {
            int isOne = n & 1;
            if (isOne == 1) 
            {
                res.add(0, index);
                //res.add(index);
            }
            ++index;
            n >>>= 1;
        }
        res.add(0, res.size());

        //System.out.println(res);

        int sub = res.get(1);
        for (int i = 1; i < res.size(); ++i) 
        {
            res.set(i, sub - res.get(i) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> out = NumberOfOneBits.getOneCount(160);
        for (int n : out) 
        {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}