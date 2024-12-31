#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
#include <algorithm>
#include <iostream>

using namespace std;

unordered_map<string,string> cars;
unordered_map<int,int> total_times;
string car_num,car_time,action;
void calculate_times(string enter_time, string out_time, string car_num);
int convert_to_minute(string car_time);
vector<int> solution(vector<int> fees, vector<string> records) {
    vector<int> answer;
    for(string record : records){
        stringstream ss(record);
        ss >> car_time >> car_num >> action;
        if(action == "IN"){
            cars[car_num] = car_time;
        }
        else if(action =="OUT"){
            if(cars.find(car_num) != cars.end()){
                calculate_times(cars[car_num], car_time, car_num);
                cars.erase(car_num);
            }
        }
    }
    
    if(!cars.empty()){
        for(const auto &pair : cars){
            const string &car_num = pair.first;
            const string &enter_time = pair.second;
            calculate_times(enter_time, "23:59", car_num);
        }
        cars.clear();
    }
    
    vector<pair<int,int>> sorted_cars (total_times.begin(), total_times.end());
    sort(sorted_cars.begin(), sorted_cars.end());
    
    for(int i=0; i<sorted_cars.size(); i++){
        int bill = 0;
        //기본요금 이하면 기본요금 청구
        if(sorted_cars[i].second <= fees[0]){
            answer.push_back(fees[1]);
        }
        else{
            int extra_time = sorted_cars[i].second - fees[0]; // 초과 시간
            int extra_fee = ((extra_time + fees[2] - 1) / fees[2]) * fees[3]; // 올림 처리
            bill = fees[1] + extra_fee; // 기본 요금 + 초과 요금
            answer.push_back(bill);
        }
    }
    
    return answer;
}
void calculate_times(string enter_time, string out_time, string car_num){
    int e_time = convert_to_minute(enter_time);
    int o_time = convert_to_minute(out_time);
    int c_num = stoi(car_num);
    total_times[c_num] += o_time - e_time;
}
int convert_to_minute(string car_time){
    int hour = stoi(car_time.substr(0,2));
    int minute = stoi(car_time.substr(3,2));
    // cout << "hour : " << hour <<'\n';
    // cout << "minute :" << minute << '\n';
    
    return hour*60 + minute;
}