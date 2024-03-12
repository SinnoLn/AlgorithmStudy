#include <bits/stdc++.h>
using namespace std;

int n, num;

int twoCheck(int n)
{
    if ((n & (-n)) == n)
        return 1;

    return 0;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> num;

        if (twoCheck(num))
            cout << 1 << '\n';
        else
            cout << 0 << '\n';
    }

    return 0;
}