import java.util.*;
import java.io.*;

//12시간제제
public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] startTime = new int[2];
        int[] endTime = new int[2];
        
        startTime[0] = Integer.parseInt(st.nextToken());
        startTime[1] = Integer.parseInt(st.nextToken());
        endTime[0] = Integer.parseInt(st.nextToken());
        endTime[1] = Integer.parseInt(st.nextToken());
        
        //두 시간더하기
        int minute = 0;
        int hour = 0;
        
        hour = startTime[0] + endTime[0] + (startTime[1] + endTime[1])/60;
        hour%=12;
        if(hour == 0) hour = 12;
        
        minute = (startTime[1] + endTime[1])%60;
        System.out.println("#"+t+" "+hour+" "+minute);
      }
  }
}