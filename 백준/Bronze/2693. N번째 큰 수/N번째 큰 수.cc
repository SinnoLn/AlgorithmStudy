#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int testCase, num;
vector<int> th, bigNum;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> testCase;

    for (int i = 0; i < testCase; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            cin >> num;
            th.push_back(num);
        }
        sort(th.begin(), th.end());
        bigNum.push_back(th[7]);
        th.clear();
    }

    for (int k : bigNum)
        cout << k << '\n';

    return 0;
}