import java.util.*;
import java.io.*;

//가로 길이는 항상 100으로 주어진다.
//모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.
//덤프 횟수는 1이상 1000이하로 주어진다.

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++){
        int[] height = new int[101];
        int dumpCnt = Integer.parseInt(br.readLine());
        int max = 100;
        int min = 1;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<100; i++){
          int h = Integer.parseInt(st.nextToken());
          height[h]++;
          max = Math.max(max, h);
          min = Math.min(min, h);
        }
        
        //구현
        while(true){
          while(height[max] == 0) max--;
          while(height[min] == 0) min++;
          
          if(dumpCnt == 0) break;
          if (max - min <= 1) break;
          
          height[max]--;
          height[max-1]++;
          height[min]--;
          height[min+1]++;
          
          dumpCnt--;
        }
        System.out.println("#" + t + " " + (max - min));
    }
  }
}