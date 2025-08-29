import java.util.*;
import java.io.*;

public class Main {
    static int BOARD = 100;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //좌하단 점 위치
      //boolean으로 체크
      //10*10*100 -> 최대 10000번 체크 
      boolean[][] check = new boolean[BOARD][BOARD];
      int n = Integer.parseInt(br.readLine());
      int ans = 0;
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        for(int k=x; k<x+10; k++){
          for(int j=y; j<y+10; j++){
            if(!check[j][k]){
              check[j][k] = true;
              ans++;
            } 
          }
        }
      }
      System.out.println(ans);
  }
}