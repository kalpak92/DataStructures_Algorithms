#include "NumberOf1Bit.h"
#include <iostream>

using namespace std;

int main()
{
    Solution s;
    uint32_t input = 123;
    int output = s.hammingWeight(input);

    cout << "The Hamming Weight is: " << output << endl;

}