#include <iostream>
#include <vector>
#include "solution.h"

using namespace std;

int main()
{
    vector<int> vect;
    vect.__emplace_back (10);
    vect.__emplace_back (10);
    vect.__emplace_back (20);

    Solution s;
    cout << s.singleNumber(vect) << endl;

    return 0;
}