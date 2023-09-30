#include <bits/stdc++.h>
using namespace std;

int n, point;
string code1, code2, input;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    cin >> input;
    point = input.find("*");
    code1 = input.substr(0, point);
    code2 = input.substr(point + 1, input.length());

    for (int i = 0; i < n; i++)
    {
        cin >> input;
        if (input.length() < code1.length() + code2.length())
            cout << "NE" << '\n';
        else
        {
            if (code1 == input.substr(0, code1.length()) && code2 == input.substr(input.length() - code2.length(), input.length()))
                cout << "DA" << '\n';
            else
                cout << "NE" << '\n';
        }
    }

    return 0;
}