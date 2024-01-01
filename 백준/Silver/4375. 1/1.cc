// 백준 4375
// 정수론의 모듈러 연산 법칙
//(a+b)%n=(a%n + b%n)%n
//(a*b)%n=(a%n * b%n)%n
#include <bits/stdc++.h>
using namespace std;

int n;
typedef long long ll;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (cin >> n) //(scanf("%d",&n) != EOF)
    {
        ll cnt = 1, ret = 1;
        while (true)
        {
            if (cnt % n == 0)
            {
                cout << ret << '\n';
                break;
            }
            else
            {
                cnt = (cnt * 10) + 1;
                cnt %= n;
                ret++;
            }
        }
    }

    return 0;
}