import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      //0 현재 속도 유지
      //1 가속 + 가속도
      //2 감속 + 가속도
      for(int t=1; t<=test; t++){
        int order = Integer.parseInt(br.readLine());
        int currSpeed = 0;
        int distance = 0;
        
        for(int i=0; i<order; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int o = Integer.parseInt(st.nextToken());
          
          if(o == 0) distance+=currSpeed;
          else if(o == 1){
            int speed = Integer.parseInt(st.nextToken());
            currSpeed+=speed;
            distance+=currSpeed;
          }
          else if(o == 2){
            int speed = Integer.parseInt(st.nextToken());
            currSpeed-=speed;
            if(currSpeed < 0) currSpeed = 0;
            distance+=currSpeed;
          }
        }
        System.out.println("#"+t+" "+distance);
      }
  }
}