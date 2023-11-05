#include <bits/stdc++.h>
using namespace std;

int n, sum, point, maxNum, p;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 1; i <= 5; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            cin >> point;
            sum += point;
        }
        if (sum > maxNum)
        {
            maxNum = sum;
            p = i;
        }
        sum = 0;
    }

    cout << p << " " << maxNum;

    return 0;
}
