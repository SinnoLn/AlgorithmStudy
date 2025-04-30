import java.util.*;
import java.io.*;

//가로 길이는 항상 100으로 주어진다.
//모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.
//덤프 횟수는 1이상 1000이하로 주어진다.

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int[] boxes = new int[100];
      for(int t=1; t<=10; t++){
        int dumpCnt = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<100; i++){
          boxes[i] = Integer.parseInt(st.nextToken());
        }
        
        //구현
        while(true){
          Arrays.sort(boxes);
          if(dumpCnt == 0) break;
          if(boxes[99]-boxes[0] <= 1) break;
          boxes[0]++;
          boxes[99]--;
          dumpCnt--;
        }
        System.out.println("#"+t+" "+(boxes[99] - boxes[0]));
      }
  }
}