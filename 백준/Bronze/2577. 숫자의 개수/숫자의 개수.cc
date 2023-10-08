#include <bits/stdc++.h>
using namespace std;
int n, sum = 1;
int number[10];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 0; i < 3; i++)
    {
        cin >> n;
        sum *= n;
    }

    while (sum > 0)
    {
        number[sum % 10]++;
        sum /= 10;
    }

    for (int k = 0; k < 10; k++)
        cout << number[k] << endl;

    return 0;
}
