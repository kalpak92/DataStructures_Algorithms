#include <iostream>
#include "solution.h"
using namespace std;

int main()
{
    Solution s;
    cout << s.getSum(100, 123) << endl;
    cout << s.getSum(-345, 321) << endl;

    return 0;
}