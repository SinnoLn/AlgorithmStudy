#include <bits/stdc++.h>
using namespace std;
long long k, n, num, middle, startLen, endLen, maxNum;
long long sum;
vector<int> length;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> k >> n;
    for (int i = 0; i < k; i++)
    {
        cin >> num;
        length.push_back(num);
        if (maxNum < num)
            maxNum = num;
    }

    startLen = 1;
    endLen = maxNum;

    while (startLen <= endLen)
    {
        sum = 0;
        middle = (startLen + endLen) / 2;
        for (int i = 0; i < length.size(); i++)
            sum += (length[i] / middle);

        if (sum < n)
            endLen = middle - 1;
        else
            startLen = middle + 1;
    }

    cout << endLen << '\n';

    return 0;
}
