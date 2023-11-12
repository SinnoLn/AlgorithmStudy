#include <bits/stdc++.h>
using namespace std;

int x, y;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> x >> y;

    if (x > 0 && y > 0)
        cout << 1 << '\n';
    else if (x > 0 && y < 0)
        cout << 4 << '\n';
    else if (x < 0 && y > 0)
        cout << 2 << '\n';
    else
        cout << 3 << '\n';

    return 0;
}