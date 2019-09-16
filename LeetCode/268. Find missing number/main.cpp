#include <iostream>
#include <vector>
#include "solution.h"

using namespace std;

int main()
{
    vector<int> vect;
    vect.__emplace_back (2);
    vect.__emplace_back (1);
    vect.__emplace_back (0);

    Solution s;
    cout << s.missingNumber(vect) << endl;

    return 0;
}