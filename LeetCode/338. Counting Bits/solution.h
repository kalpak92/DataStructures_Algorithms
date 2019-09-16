/*************************************************************************************** 
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ 
 * num calculate the number of 1's in their binary representation and return them as an 
 * array.
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * *************************************************************************************/
#include <vector>
using namespace std;

class Solution
{
    public:
    /* 
     *   Initialization
     * 
     *   bits_cnt[0] => 0000 => 0
     *   bits_cnt[1] => 0001 => 1
     * 
     *   if the number has 2 bits (2, 3), then we can split the binary to two parts, 
     *   2 = 10 + 0  and  3= 10 + 1, then we can reuse the bits_cnt[0] and bits_cnt[1] 
     *
     *   bits_cnt[2] => 0010 => 0010 + 0 => 1 + bits_cnt[0];
     *   bits_cnt[3] => 0011 => 0010 + 1 => 1 + bits_cnt[1];
     *
     *   if the number has 3 bits (4,5,6,7), then we can split the binary to two parts, 
     *   4 = 100 + 0,  5 = 100 + 01, 6= 100 + 10, 7 = 100 +11
     *   then we can reuse the bits_cnt[0] and bits_cnt[1] 
     * 
     *   bits_cnt[4] => 0110 => 0100 + 00 => 1 + bits_cnt[0];
     *   bits_cnt[5] => 0101 => 0100 + 01 => 1 + bits_cnt[1];
     *   bits_cnt[6] => 0110 => 0100 + 10 => 1 + bits_cnt[2];
     *   bits_cnt[7] => 0111 => 0100 + 11 => 1 + bits_cnt[3];
     *
     * so, we can have the solution:
     *
     *              bits_cnt[x] = bits_cnt[x & (x-1) ] + 1;
     *
     */
        vector<int> countBits(int num)
        {
            vector<int> result(num+1, 0);

            for (int i = 1; i <= num; i++)
            {
                result[i] = result[(i & (i-1))] + 1;
            }
            return result;
        }
};
