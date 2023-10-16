// 백준 9375

#include <bits/stdc++.h>
using namespace std;

int testCase, n, position, sum;
map<string, int> clothes;
string clothe;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> testCase;

    for (int i = 0; i < testCase; i++)
    {
        clothes.clear();
        sum = 1;
        cin >> n;
        cin.ignore();
        for (int j = 0; j < n; j++)
        {
            getline(cin, clothe);
            position = clothe.find(" ");
            clothe = clothe.substr(position + 1);
            if (clothes.find(clothe) != clothes.end())
            {
                clothes[clothe]++;
            }
            else
                clothes.insert({clothe, 1});
        }

        for (const auto &pair : clothes)
        {
            sum *= (pair.second + 1);
        }

        cout << sum - 1 << '\n';
    }

    return 0;
}