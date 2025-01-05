#include <string>
#include <vector>
#include <iostream>
#define MAX_SIZE 50

using namespace std;

int parkint[MAX_SIZE][MAX_SIZE];
int x, y, park_width, park_height;
bool check_condition(int ny, int nx, int sign);
vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    park_width = park[0].size();
    park_height = park.size();
    for(int i=0; i<park_height; i++){
        for(int j=0; j<park_width; j++){
            if(park[i][j] == 'S'){
                y = i;
                x = j;
                parkint[i][j] = 0;
            }
            else if(park[i][j] == 'O') parkint[i][j] = 0;
            else if(park[i][j] == 'X') parkint[i][j] = 1;
        }
    }
    
    for(string s : routes){
        char direction = s[0];
        int num = s[2]-'0';
        
        if(direction == 'E'){
            if(check_condition(y, x+num, 1)) x+=num;
        }
        else if(direction == 'S'){
            if(check_condition(y+num, x, 1)) y+=num;
        }
        else if(direction == 'W'){
            if(check_condition(y, x-num, -1)) x-=num;
        }
        else if(direction == 'N'){
            if(check_condition(y-num, x, -1)) y-=num;
        }
        
        cout << "y " << y << " x " << x <<'\n';  
    }
    answer.push_back(y);
    answer.push_back(x);
    return answer;
}
bool check_condition(int ny, int nx, int sign){
    if(nx < 0 || ny < 0 || nx >= park_width || ny >= park_height) return false;
    if(parkint[ny][nx] == 1) return false;
    //가로 탐색
    if(nx != x){
        for(int i=x; i!=nx; i+=sign){
            if(parkint[y][i] == 1) {
                return false;
            }
        }
    }
    //세로 탐색
    else if(ny != y){
        for(int i=y; i!=ny; i+=sign){
            if(parkint[i][x] == 1){
                return false;
            }
        }
    }
    return true;
}