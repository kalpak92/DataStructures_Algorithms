public class DuplicateNumber
{
    public int findDuplicate(int[] arr)
    {
        /**
         * Floyd's Tortoise and Hare Algorithm
         *
         * Proof:
         *   start-----entry-------
         *               |        |
         *               --------meeting point
         *   x: distance from start to entry
         *   y: distance from entry to meeting point
         *   c: cycle length
         *
         *   When tortoise and hare meets at meeting point,
         *     tortoise traveled: x + y,
         *     hare traveled: x + y + n*c (which is x + y + several loops inside the circle)
         *
         *   And hare is twice faster than tortoise, so
         *     2(x + y) = x + y + n*c
         *
         *   Then we can get
         *     x = n*c - y
         *     x = (n-1)*c + (c-y)
         *
         *   Which means
         *     traveling from start to entry (distance is x) and
         *     traveling from meeting point to entry (c-y + several loops in circle)
         *     will finally meet at entry
         */

         /**
          * Step 1:
          * The array's indices are in [0, n]. The array's values are in [1, n]. 
          * This means nums[0] will lead us to an index that is in [1, n] (because nums[0] is a value). 
          * But nobody will lead us back to index 0 (because everyone's value is in [1, n] not including 0).
          * 
          * Step 2:
          * Starting from index 0, we can definitely reach a cycle. Why? By contradiction. 
          * If we cannot reach a cycle, that is to say, we always meet a new index, and then meet a new index, but there are only finite number of indices. So we will reach a cycle.
          * 
          * Step 3:
          * Then this cycle's entrace's index must be one duplicated number (because two guys lead us to it).
          * 
          * Step 4:
          * Since there is only one duplicated number, then that's it.
          */

         int slow = arr[0];
         int fast = arr[arr[0]];

         while(slow != fast)
         {
             slow = arr[slow];
             fast = arr[arr[fast]];
         }

         slow = 0;
         while(slow != fast)
         {
             slow = arr[slow];
             fast = arr[fast];
         }

         return slow;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};

        DuplicateNumber obj = new DuplicateNumber();
        System.out.println(x);
    }
}