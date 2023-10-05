#include <iostream>
using namespace std;
string word;
int hashResult = 0, wordLength, key = 1;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> wordLength;
    cin >> word;

    for (int i = 0; i < wordLength; i++)
    {
        hashResult += (word[i] - 'a' + 1) * key;

        if (key == 1)
            key += 30;
        else
            key *= 31;
    }
    cout << hashResult << '\n';

    return 0;
}