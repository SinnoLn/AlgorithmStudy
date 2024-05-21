/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
using namespace std;
int n, t=-10;
string s;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin>>n;
    
    for(int i=0; i<n; i++)
    {
        cin>>s;
        
        if(t == -10)
        {
            t = s[0];
        }
        else if(t != s[0])
        {
            t = -11;
        }
    }

    if(t == -11)
    cout<<"0"<<'\n';
    else 
    cout<<"1"<<'\n';
    
    return 0;
}


