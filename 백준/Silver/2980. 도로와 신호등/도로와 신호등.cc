#include <iostream>
#include <vector>

using namespace std;

int n,l,d,r,g,pos,time_,idx; //pos : 현재위치
vector<pair<int,int>> v;
int sinn[100];

int main(){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> l;

    //신호등 정보 입력
    for(int i=0; i<n; i++){
        cin >> d >> r >> g;
        v.push_back({r, g});
        sinn[i] = d;
    }

    for(time_ = 0; pos != l; time_ ++){
        if(pos == sinn[idx]){ //현재 신호등 위치면 
            int cycle =  v[idx].first + v[idx].second;
            if((time_%cycle) <= v[idx].first-1) //빨간불이면
                continue; //멈춤
            else{
                idx++; //다음 신호등으로 가기
                pos++; //움직임
            } 
        }
        else //신호등이 아니면 건너감
            pos++;
    }
    cout << time_ << '\n';
}
