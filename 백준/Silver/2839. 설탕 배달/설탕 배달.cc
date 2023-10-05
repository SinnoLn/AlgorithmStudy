#include <iostream>
using namespace std;

int n, result;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    // Greedy 알고리즘
    // 매 단계마다 가장 최적의 해를 선택한다.

    while (n >= 0)
    {
        if (n % 5 == 0)
        {
            result += n / 5;
            cout << result << '\n';
            return 0;
        }

        n -= 3;
        result++;
    }
    cout << -1 << '\n';

    return 0;
}