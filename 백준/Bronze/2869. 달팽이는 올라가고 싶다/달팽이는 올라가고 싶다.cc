#include <bits/stdc++.h>
using namespace std;

int a, b, v;
int period;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> a >> b >> v;

    period = (v - b - 1) / (a - b) + 1;

    cout << period << "\n";
    return 0;
}