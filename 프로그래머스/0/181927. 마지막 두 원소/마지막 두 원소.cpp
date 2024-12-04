#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    int size = num_list.size();
    if(num_list[size-1] > num_list[size-2]) 
        num_list.push_back(num_list[size-1]-num_list[size-2]);
    else if(num_list[size-1]<=num_list[size-2])
        num_list.push_back(num_list[size-1]*2);
    
    return num_list;
}