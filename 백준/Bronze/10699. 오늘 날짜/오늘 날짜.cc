#include <bits/stdc++.h>

using namespace std;

int main()
{

    time_t now = time(0);
    tm *ltm = localtime(&now);

    cout << 1900 + ltm->tm_year << "-" << setw(2) << setfill('0') << 1 + ltm->tm_mon << "-"
         << setw(2) << setfill('0') << ltm->tm_mday << '\n';

    return 0;
}