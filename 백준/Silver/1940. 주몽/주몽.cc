// 백준 1940
// Hash Map으로 풀어보겠음
// 1. 많은 자료를 저장하고, 검색 속도가 빨라야 한다.
// 2. 너무 빈번하게 자료를 삽입, 삭제하지 않는다.
//... Map으로 품 (자동 오름차순)

#include <bits/stdc++.h>
using namespace std;
map<int, int> mp;
int n, m, num, target, countNum;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    cin >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> num;
        mp[num]++;
    }

    for (const auto &kv : mp)
    {
        int key = kv.first;
        target = m - key;

        if (target >= 1 && mp.find(target) != mp.end())
        {
            while (mp[key] > 0)
            {
                countNum++;
                mp[key]--;
            }
        }
    }
    cout << countNum / 2 << '\n';

    return 0;
}