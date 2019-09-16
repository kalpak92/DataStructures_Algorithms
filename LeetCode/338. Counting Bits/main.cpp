#include <iostream>
#include <vector>
#include "solution.h"
using namespace std;

int main()
{
    Solution s;
    vector<int> result = s.countBits(10);

    for (int val : result)
        cout << val << " ";
    cout << endl;

    return 0;  
}