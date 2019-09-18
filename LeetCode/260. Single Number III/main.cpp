#include <iostream>
#include <vector>
#include "solution.h"

using namespace std;

int main()
{
    vector<int> n;

    n.push_back(1);
    n.push_back(2);
    n.push_back(1);
    n.push_back(3);
    n.push_back(2);
    n.push_back(5);

    Solution s;
    vector<int> result = s.singleNumber(n);

    for (int i = 0; i < result.size(); i++)
    {
      cout << result[i] << " ";
    }
    cout << endl;
    
    return 0;
}