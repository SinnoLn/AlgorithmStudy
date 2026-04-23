import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<number.length(); i++){
            int num = number.charAt(i)-'0';
            
            while(sb.length() > 0 && k>0 && sb.charAt(sb.length()-1)-'0' < num){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            
            sb.append(num);
        }
        
        return sb.substring(0, sb.length() - k);
    }
}