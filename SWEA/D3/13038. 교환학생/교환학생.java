import java.util.*;
import java.io.*;

public class Solution {
    static int[] lesson;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      //교환학생 n일동안 수업듣기
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        
        //일,월,화,수,목,금,토
        lesson = new int[7];
        int weekSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<7; i++){
          lesson[i] = Integer.parseInt(st.nextToken());
          if(lesson[i] == 1) weekSum++;
        }
        
        int day = 0;
        if(weekSum<n){
        int tmp = n/weekSum-1;
        day+=tmp*7;
        n-=tmp*weekSum;
        }
        
        //시작일 결정
        int minDay=10000000;
        for(int i=0; i<7; i++){
          int idx = i;
          int leftDay = 0;
          int leftN = n;
          while(true){
            if(leftN==0) break;
            idx = (idx+1)%7;
            leftDay++;
            if(lesson[idx] == 0) continue;
            leftN--;
          }
          minDay = Math.min(minDay,leftDay);
        }
        
        System.out.println("#"+t+" "+(day+minDay));
      }
  }
}