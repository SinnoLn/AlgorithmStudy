#include <iostream>

using namespace std;

int n, cnt, num;

int main() {

    cin >> n;
    for(int i=666; cnt!= n; i++){
        string a = to_string(i);

        if(a.find("666") != string::npos){
            cnt++;
            num = i;
        }
    }

    cout << num << '\n';
    return 0;
}