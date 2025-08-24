import java.io.*;
import java.util.*;

//모든 달은 28일
class Solution {
    static int ty, tm, td, toDays;
    static int[] answer;
    static Map<Character, Integer> map = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) throws IOException{
        String[] parts = today.split("\\.");
        answer = new int[privacies.length];
        
        ty = Integer.parseInt(parts[0]);
        tm = Integer.parseInt(parts[1]);
        td = Integer.parseInt(parts[2]);
        
        toDays = ty*12*28+tm*28+td;
        System.out.println(toDays);
            
        for(String t : terms){
            String[] parts2 = t.split(" ");
            map.put(parts2[0].charAt(0), Integer.parseInt(parts2[1]));
        }
        
        int idx = 0;
        for(int i=0; i<privacies.length; i++){
            if(isExpired(privacies[i])){
                answer[idx] = i+1;
                idx++;
            }  
        }
        return Arrays.copyOf(answer, idx);
    }
    
    static boolean isExpired(String data){
        String d = data.substring(0,10);
        char c = data.substring(11).charAt(0);
        
        String[] parts3 = d.split("\\.");
        int cy = Integer.parseInt(parts3[0]);
        int cm = Integer.parseInt(parts3[1]);
        int cd = Integer.parseInt(parts3[2]);
        
        int totalDays = cy*12*28+cm*28+cd;        
        int leftDays = toDays-totalDays;
        
        if(leftDays >= map.get(c)*28) return true;
        else return false;
    }
}