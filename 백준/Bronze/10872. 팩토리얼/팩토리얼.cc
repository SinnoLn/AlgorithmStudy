#include <bits/stdc++.h>

using namespace std;
int sum = 1, n;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    if (n == 0)
    {
        cout << 1 << '\n';
        return 0;
    }

    for (int i = n; i > 1; i--)
        sum *= i;

    cout << sum << '\n';

    return 0;
}