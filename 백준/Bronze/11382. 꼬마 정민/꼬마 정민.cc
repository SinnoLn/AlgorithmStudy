#include <bits/stdc++.h>
using namespace std;

long long int num, sum;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 0; i < 3; i++)
    {
        cin >> num;
        sum += num;
    }

    cout << sum << '\n';

    return 0;
}