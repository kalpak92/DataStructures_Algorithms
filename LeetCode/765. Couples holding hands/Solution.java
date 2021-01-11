/**
 * N couples sit in 2N seats arranged in a row and want to hold hands. 
 * We want to know the minimum number of swaps so that every couple is sitting side by side. 
 * A swap consists of choosing any two people, then they stand up and switch seats.
 * 
 * The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), 
 * the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
 * 
 * The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.
 * Example 1:
 * Input: row = [0, 2, 1, 3]
 * Output: 1
 * Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
 * 
 * Example 2:
 * Input: row = [3, 2, 0, 1]
 * Output: 0
 * Explanation: All couples are already seated side by side.
 * 
 * Note:
 * len(row) is even and in the range of [4, 60].
 * row is guaranteed to be a permutation of 0...len(row)-1.
 */

public class Solution {
    public int minSwapsCouples(int[] row) {
        int result = 0;
    
        int[] ptn = new int[row.length];    // denotes the partner of label i 
        int[] pos = new int[row.length];    // denotes the index of the person with label i in the row array 

        for (int i = 0; i < row.length; i++) {
            ptn[i] = (i % 2 == 0 ? i + 1 : i - 1);
            pos[row[i]] = i;
        }
        
        // The meaning of i == ptn[pos[ptn[row[i]]]] is as follows:
        // The person sitting at seat i has a label row[i], and we want to place him/her next to his/her partner.
        // So we first find the label of his/her partner, which is given by ptn[row[i]].
        // We then find the seat of his/her partner, which is given by pos[ptn[row[i]]].
        // Lastly we find the seat next to his/her partner's seat, which is given by ptn[pos[ptn[row[i]]]].

        for (int i = 0; i < row.length; i++) {
            for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]) {
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                result++;
            }
        }

        return result;
    }
    
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}