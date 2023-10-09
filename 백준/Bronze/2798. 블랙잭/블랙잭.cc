#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, sum, card, maxNum;
vector<int> blackJack;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < N; i++)
    {
        cin >> card;
        blackJack.push_back(card);
    }

    sort(blackJack.begin(), blackJack.end());

    for (int i = blackJack.size() - 1; i >= 2; i--)
        for (int j = i - 1; j >= 1; j--)
            for (int l = j - 1; l >= 0; l--)
            {
                sum = blackJack[i] + blackJack[j] + blackJack[l];
                if (sum <= M && maxNum < sum)
                {
                    maxNum = sum;
                }
            }

    cout << maxNum << endl;
    return 0;
}