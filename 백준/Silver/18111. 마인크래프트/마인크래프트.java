import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //땅의 높이 256 초과 불가
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      int[] block = new int[257];
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++){
          int num = Integer.parseInt(st.nextToken());
          block[num]++; 
        }
      }
      
      //(2초)좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣기
      //(1초)인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓기
      
      //이미 b개의 블록이 인벤토리에 들어있다.
      
      int bestTime = Integer.MAX_VALUE;
      int bestHeight = 0;
      
      //모든 경우의 수 구하기
      for(int h=0; h<257; h++){
        int inv = b;
        int time = 0;
        
        // 현재 높이 i별로 계산
        for(int i=0; i<257; i++){
          int cnt = block[i];
          if(cnt == 0) continue;
          
          if(i>h){
            //블록 제거
            int diff = i-h;
            int blocks = diff*cnt;
            time+= 2*blocks;
            inv += blocks;
          }
          else if(i<h){
            //블록 쌓기
            int diff = h-i;
            int blocks = diff*cnt;
            time+= blocks;
            inv -= blocks;
          }
        }
        
        if(inv < 0) continue;
        
        if(time<bestTime || (time==bestTime&&h>bestHeight)){
          bestTime = time;
          bestHeight = h;
        }
      }
      
      System.out.println(bestTime + " " + bestHeight);
  }
}