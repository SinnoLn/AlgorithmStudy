#include <string>
#include <vector>
#include <bitset>

using namespace std;

int position;
string solution(string bin1, string bin2) {
    string answer = "";
    bitset<10> bit1(bin1);
    bitset<10> bit2(bin2);
    
    unsigned long sum = bit1.to_ulong() + bit2.to_ulong();
    
    answer = bitset<12>(sum).to_string();
    
    for(int i=0; i<answer.size(); i++){
        if(answer[i] == '1'){
            position = i;
            break;
        }
    }
    if(position == 0) return "0";
    else{
        answer.erase(0, position);
        return answer;
    }
}