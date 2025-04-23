import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      //현재 속도보다 감속할 속도가 클 경우 속도는 0
      for(int test=1; test<=t; test++){
        int n = Integer.parseInt(br.readLine());
        int speed = 0;
        int acc = 0;
        int dis = 0;
        
        //0 현재 속도 유지
        //1 가속
        //2 감속
        for(int i=0; i<n; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
        
            switch(op){
              case 0:
                dis+=speed;
                break;
              case 1:
                acc = Integer.parseInt(st.nextToken());
                speed+=acc;
                dis+=speed;
                break;
              case 2:
                acc = Integer.parseInt(st.nextToken());
                speed-=acc;
                if(speed<=0) speed = 0;
                else dis+=speed;
            }
        }
        System.out.println("#"+test+" "+dis);
      }
  }
}