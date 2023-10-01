// 백준 2559 수열
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int temp[100000];
int term, num, sum, maxNum = -2100000000;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> num >> term;

    for (int i = 0; i < num; i++)
    {
        cin >> temp[i];
        if (i < term)
        {
            sum += temp[i];
            if (i == term - 1)
                maxNum = sum;
        }
        else
        {
            sum = sum - temp[i - term] + temp[i];
            if (sum > maxNum)
                maxNum = sum;
        }
    }

    cout << maxNum << '\n';

    return 0;
}