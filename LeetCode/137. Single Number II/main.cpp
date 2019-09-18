#include <iostream>
#include <vector>
#include "solution.h"

using namespace std;

int main()
{
    Solution s;
    vector<int> v;
    v.push_back(0);
    v.push_back(1);
    v.push_back(99);
    v.push_back(0);
    v.push_back(1);
    v.push_back(0);
    v.push_back(1);

    cout << "The number occuring once is " << s.singleNumber(v) << endl;

    return 0;
}