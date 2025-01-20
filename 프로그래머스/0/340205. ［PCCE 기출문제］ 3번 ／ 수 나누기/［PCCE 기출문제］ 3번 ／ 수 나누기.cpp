#include <iostream>

using namespace std;

int main(void) {
    int number;
    cin >> number;
    
    int answer = 0;
    
    for(int i=0; number != 0; i++){
        answer += number % 100;
        number /= 100;
    }
    cout << answer << endl;
    return 0;
}