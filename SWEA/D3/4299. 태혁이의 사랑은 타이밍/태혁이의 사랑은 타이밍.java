import java.util.*;
import java.io.*;

//분으로 전환
public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        int ans = calTime(day, hour, minute);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int calTime(int day, int hour, int minute){
    int time = 11*24*60 + 11*60+ 11;
    int eTime = day*24*60 + hour*60 + minute;
    
    if(eTime-time<0) return -1;
    else return eTime-time;
  }
}