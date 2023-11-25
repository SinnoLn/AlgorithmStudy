#include <bits/stdc++.h>
#include <iomanip>
using namespace std;

string grade;
float score;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> grade;

    if (grade == "A+")
        score = 4.3f;
    else if (grade == "A0")
        score = 4.0f;
    else if (grade == "A-")
        score = 3.7f;
    else if (grade == "B+")
        score = 3.3f;
    else if (grade == "B0")
        score = 3.0f;
    else if (grade == "B-")
        score = 2.7f;
    else if (grade == "C+")
        score = 2.3f;
    else if (grade == "C0")
        score = 2.0f;
    else if (grade == "C-")
        score = 1.7f;
    else if (grade == "D+")
        score = 1.3f;
    else if (grade == "D0")
        score = 1.0f;
    else if (grade == "D-")
        score = 0.7f;
    else
        score = 0.0f;

    cout << fixed << setprecision(1) << score << '\n';

    return 0;
}