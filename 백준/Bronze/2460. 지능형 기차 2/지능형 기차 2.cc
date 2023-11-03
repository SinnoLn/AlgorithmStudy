#include <bits/stdc++.h>
using namespace std;

int subway, n, m, maxNum = 0;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 0; i < 10; i++)
    {
        cin >> n >> m;
        subway += (m - n);

        if (subway > maxNum)
            maxNum = subway;
    }

    cout << maxNum << '\n';

    return 0;
}