#include <bits/stdc++.h>
using namespace std;

long long a,b,c, result;

long long go(long long a, long long b)
{
//기저사례 작성
if(b==1) 
return a%c;

result = go(a,b/2);
result = (result*result)%c;

//홀수일 경우
if(b%2 == 1)
result = (result*a)%c;

return result;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin>>a>>b>>c;
    cout<<go(a,b)<<'\n';

    return 0;
}