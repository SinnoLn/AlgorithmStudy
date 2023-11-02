#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n, m, num, a, b;
vector<int> baskets;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    for (int i = 1; i <= n; i++)
    {
        baskets.push_back(i);
    }

    for (int j = 0; j < m; j++)
    {
        cin >> a >> b;
        swap(baskets[a - 1], baskets[b - 1]);
    }

    for (int k : baskets)
        cout << k << " ";

    return 0;
}