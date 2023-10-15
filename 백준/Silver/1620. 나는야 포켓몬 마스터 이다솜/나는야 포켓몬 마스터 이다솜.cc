// 1620 백준

#include <bits/stdc++.h>
using namespace std;

int num, question;
string name;
map<string, int> pocketmonName;
map<int, string> pocketmonNum;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> num >> question;
    for (int i = 1; i <= num; i++)
    {
        cin >> name;
        pocketmonNum.insert({i, name});
        pocketmonName.insert({name, i});
    }

    for (int j = 0; j < question; j++)
    {
        cin >> name;
        if ((name[0] >= 'A' && name[0] <= 'Z') ||
            (name[name.length() - 1] >= 'A' && name[name.length() - 1] <= 'Z'))
        {
            cout << pocketmonName[name] << '\n';
        }
        else
        {
            cout << pocketmonNum[atoi(name.c_str())] << '\n';
        }
    }

    return 0;
}