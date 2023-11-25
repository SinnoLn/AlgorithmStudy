#include <bits/stdc++.h>

using namespace std;
int n, num, point, arr[202];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> num;
        if (num < 0)
            num += 201;
        arr[num]++;
    }

    cin >> point;

    if (point < 0)
        cout << arr[point + 201];
    else
        cout << arr[point] << '\n';

    return 0;
}