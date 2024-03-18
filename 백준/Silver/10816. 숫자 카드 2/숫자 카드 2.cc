#include <iostream>
#include <unordered_map>
using namespace std;

int n, m, card;
unordered_map<int, int> cardCount;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> card;
        cardCount[card]++;
    }

    cin >> m;
    for (int j = 0; j < m; j++)
    {
        cin >> card;
        cout << cardCount[card] << ' ';
    }
    return 0;
}