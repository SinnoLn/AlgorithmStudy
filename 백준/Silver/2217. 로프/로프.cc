#include <bits/stdc++.h>
using namespace std;
int n, j, k, weight, maxWeight, tmp = 1;
vector<int> rope;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> weight;
        rope.push_back(weight);
    }

    sort(rope.begin(), rope.end());

    for (j = 0; j < rope.size(); j++)
    {
        tmp = 0;

        tmp = n * rope[j];

        if (tmp > maxWeight)
        {
            maxWeight = tmp;
        }
        n--;
    }

    std::cout << maxWeight << '\n';

    return 0;
}