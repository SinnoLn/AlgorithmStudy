#include <iostream>
#include <queue>
using namespace std;

int n, tmp;
queue<int> q;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 1; i <= n; i++)
        q.push(i);

    while (q.size() > 1)
    {
        q.pop();
        q.push(q.front());
        q.pop();
    }

    if (!q.empty())
    {
        cout << q.front() << '\n'; // 마지막으로 남은 카드 출력
    }

    return 0;
}