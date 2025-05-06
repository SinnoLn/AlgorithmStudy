import java.util.*;
import java.io.*;

//시 1시 부터 12시
//분 0분 부터 59분
public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour1 = Integer.parseInt(st.nextToken());
        int minute1 = Integer.parseInt(st.nextToken());
        int hour2 = Integer.parseInt(st.nextToken());
        int minute2 = Integer.parseInt(st.nextToken());
        
        int minute = (minute1+minute2)%60;
        int hour = (hour1 + hour2 + (minute1+minute2)/60)%12;
        
        if(hour == 0) hour = 12;
        
        System.out.println("#"+t+" "+hour+" "+minute);
      }
  }
}