#include <iostream>
using namespace std;

int n, k;
int binoCoe = 1; 

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> k;

    if (k == 0)
    {
        cout << "1" << '\n';
        return 0;
    }

    for (int i = n; i >= n - k + 1; i--)
        binoCoe *= i;

    for (int i = 1; i <= k; i++)
        binoCoe /= i;

    cout << binoCoe << '\n';

    return 0;
}