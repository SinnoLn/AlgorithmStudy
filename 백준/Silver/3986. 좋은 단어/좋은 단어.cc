// 백준 3986
#include <bits/stdc++.h>
using namespace std;

int n, countNum;
string word;
stack<char> words;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> word;

        for (char c : word)
        {
            if (!words.empty() && words.top() == c)
                words.pop();
            else
                words.push(c);
        }

        if (words.empty())
            countNum++;

        while (!words.empty())
            words.pop();
    }

    cout << countNum << "\n";

    return 0;
}