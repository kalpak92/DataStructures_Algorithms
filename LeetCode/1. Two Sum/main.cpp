#include <iostream>
#include <vector>
#include "solution.h"

using namespace std;

int main()
{
    vector<int> v;
    v.push_back(2);
    v.push_back(7);
    v.push_back(11);
    v.push_back(15);

    Solution s;
    vector<int> result = s.twoSum(v, 9);

    cout << "Two sum positions are ";

    for (int i = 0; i < result.size(); i++)
    {
        cout << result[i] << " ";
    }
    cout << endl;
}