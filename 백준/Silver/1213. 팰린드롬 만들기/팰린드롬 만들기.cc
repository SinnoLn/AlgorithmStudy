#include <bits/stdc++.h>
using namespace std;

int alphabet[26];
string words, fewords, rewords;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> words;

    for (int i = 0; i < words.length(); i++)
        alphabet[words[i] - 'A']++;

    if (words.length() % 2 == 0) // 짝수일때
    {
        for (int k = 0; k < 26; k++)
        {
            if (alphabet[k] % 2 == 1)
            {
                cout << "I'm Sorry Hansoo" << '\n';
                return 0;
            }
            else if (alphabet[k] != 0)
            {
                for (int j = 0; j < alphabet[k] / 2; j++)
                    fewords += k + 'A';
            }
        }
        rewords = fewords;
        reverse(rewords.begin(), rewords.end());
        fewords += rewords;
    }
    else if (words.length() % 2 == 1) // 홀수일때
    {
        int oddCount = 0;
        char oddChar; // 홀수번 등장하는 알파벳 저장

        for (int k = 0; k < 26; k++)
        {
            if (alphabet[k] % 2 == 1)
            {
                oddCount++;
                oddChar = k + 'A';
            }
            for (int j = 0; j < alphabet[k] / 2; j++)
                fewords += k + 'A';
        }

        if (oddCount != 1) // 홀수번 등장하는 알파벳이 1개가 아닌 경우
        {
            cout << "I'm Sorry Hansoo" << '\n';
            return 0;
        }

        rewords = fewords;
        reverse(rewords.begin(), rewords.end());
        fewords = fewords + oddChar + rewords; 
    }

    cout << fewords << '\n';

    return 0;
}