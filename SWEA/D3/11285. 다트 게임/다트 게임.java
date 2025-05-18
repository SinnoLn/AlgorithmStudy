import java.util.*;
import java.io.*;

public class Solution {
    static int[] dartPoint = {0,200,180,160,140,120,100,80,60,40,20,0};
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      //r = 20 * (11 - p)인 경우 p점을 획득
      for(int t=1; t<=test; t++){
        int sum = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int y = Integer.parseInt(st.nextToken());
          int x = Integer.parseInt(st.nextToken());
          
          double r = Math.sqrt(y*y+x*x);
          int point = 0;
          for(int j=1; j<11; j++){
            if(dartPoint[j] >= r && dartPoint[j+1] < r){
              point = j;
              break;
            }
          }
          if(r < 20) point = 10;
          sum+=point;
        }
        System.out.println("#"+t+" "+sum);
      }
  }
}