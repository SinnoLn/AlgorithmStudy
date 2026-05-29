import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // s의 길이 1000 이하
        // 문자열을 회전시켰을때 올바른 괄호 문자열이 될 수 있는가
        
        if(s.length()%2!=0) return answer;
        
        for(int i=0; i<s.length(); i++) {
            if(isPossible(s, i)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPossible(String s, int startIdx) {
        StringBuilder stack = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt((i+startIdx)%s.length());
            
            if(stack.length() == 0) stack.append(c);
            else if(c == '(' || c == '[' || c == '{') stack.append(c);
            else {
                if(stack.charAt(stack.length()-1) == '(' && c == ')') stack.setLength(stack.length()-1);
                else if(stack.charAt(stack.length()-1) == '[' && c == ']') stack.setLength(stack.length()-1);
                else if(stack.charAt(stack.length()-1) == '{' && c == '}') stack.setLength(stack.length()-1);
                else return false;
            }
        }
        
        if(stack.length() != 0) return false;
        return true;
    }
}