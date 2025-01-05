#include <string>
#include <vector>
#include <iostream>

using namespace std;
vector<string> num={"0","1","2","3","4","5","6","7","8","9"};
vector<string> num_string={"zero","one","two","three","four","five","six","seven","eight","nine"};
long long solution(string numbers) {
    long long answer = 0;
    for(int i=0; i<num_string.size(); i++){
        while(numbers.find(num_string[i]) != string::npos){
            numbers.replace(numbers.find(num_string[i]), num_string[i].length(), num[i]);
        }
    }
    answer = stol(numbers);
    return answer;
}