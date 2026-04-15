import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) throws IOException{
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                sb.append(c);
                isFirst = true;
            } 
            else if(isFirst){
                if(c >= 'a' && c <= 'z') sb.append((char)(c - 32));
                else sb.append(c);
                isFirst = false;
            } 
            else {
                if(c >= 'A' && c <= 'Z') sb.append((char)(c + 32));
                else sb.append(c);
            }
        }
        
        return sb.toString();
    }
}