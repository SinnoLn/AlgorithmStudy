#include <iostream>

using namespace std;

int student, size_[6], pb, tb, tans, pbans, pans;

int main(){

    cin >> student;
    for(int i=0; i<6; i++){
        int a;
        cin >> a;
        size_[i] = a; 
    }

    cin >> tb >> pb;
    for(int i = 0; i < 6; i++) {
        tans += (size_[i] + tb - 1) / tb; 
    }

    pbans = student/pb;
    pans = student%pb;

    cout << tans << '\n';
    cout << pbans << " " << pans<<'\n';
    return 0;
}