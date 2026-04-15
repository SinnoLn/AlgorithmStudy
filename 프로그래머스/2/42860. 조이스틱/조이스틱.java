import java.io.*;
import java.util.*;

class Solution {
    public int solution(String name) throws IOException{
        int answer = 0;
        char[] word = new char[name.length()];
        
        for(int i = 0; i < name.length(); i++){
            word[i] = name.charAt(i);
        }
        
        answer = solve(word); 
        return answer;
    }
    
    static int solve(char[] word){
        int cnt = 0; 
        int len = word.length;
        
        int move = len-1; 
        
        for(int i = 0; i < len; i++){
            char c = word[i];
            cnt += Math.min(c-'A', 'Z'-c+1);
            
            int next = i + 1;
            while(next < len && word[next] == 'A') {
                next++;
            }
            
            int way1 = move;
            int way2 = (i * 2) + (len - next);
            int way3 = i + (len - next) * 2;
            
            move = Math.min(way1,Math.min(way2,way3));
        }
        return cnt + move;
    }
}