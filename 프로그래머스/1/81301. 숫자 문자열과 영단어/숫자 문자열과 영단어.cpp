#include <string>
#include <vector>

using namespace std;

vector<string> string_num= {"zero","one","two","three","four","five","six","seven","eight","nine"};
string tmp;
int solution(string s) {
    int answer = 0;
    for(int i=0; i<string_num.size(); i++){
        while(s.find(string_num[i]) != string::npos){
            s.replace(s.find(string_num[i]),string_num[i].size(),to_string(i));
        }
    }
    answer = stoi(s);
    return answer;
}