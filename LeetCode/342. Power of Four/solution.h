#include <iostream>

using namespace std;

class Solution
{
    public:
        bool isPowerOfFour(int num)
        {
            int count = 0;

            if (num <= 0)
                return false;
            
            if (num && !(num & (num - 1)))
            {
                while (num > 1)
                {
                    num >>= 1;
                    count++;
                }
                return (count % 2 == 0) ? true : false;
            }
            return false;            
        }
};