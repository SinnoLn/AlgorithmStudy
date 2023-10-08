#include <bits/stdc++.h>
using namespace std;
string words;
int countNum, Num;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    getline(cin, words);

    if (words == " ")
    {
        cout << 0 << endl;
        return 0;
    }

    if (words[0] == ' ')
        words = words.erase(0, 1);

    if (words[words.length() - 1] == ' ')
        words = words.erase(words.length() - 1, 1);

    for (int i = 0; i < words.length(); i++)
    {
        if (words[i] == ' ')
            countNum++;
    }
    countNum++;

    cout << countNum << endl;

    return 0;
}
