#include <iostream>
using namespace std;

int main() {
    int T, a, b;
    cin >> T;

    while (T--) {
        cin >> a >> b;
        int result = 1;

        for (int i = 0; i < b; i++) {
            result = (result * a) % 10;
        }

        if (result == 0) {
            cout << 10 << '\n'; 
        } else {
            cout << result << '\n'; 
        }
    }

    return 0;
}
