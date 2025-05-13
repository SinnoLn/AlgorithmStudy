import java.util.*;
import java.io.*;

public class Solution {
    static int[][] ladder;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=0; t<10; t++){
        int test = Integer.parseInt(br.readLine());
        ladder = new int[100][100];
        int start = 0;
        
        for(int i=0; i<100; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<100; j++){
            ladder[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        for(int i=0; i<100; i++){
          if(ladder[99][i] == 2){
            start = findDestination(99,i);
            break;
          }
        }
        System.out.println("#"+test+" "+start);
      }
  }
  
  //위로 올라가며 이동
  static int findDestination(int y, int x){
    while(y>0){
      //왼쪽 확인
      if(x > 0 && ladder[y][x-1] == 1){
        while(x > 0 && ladder[y][x-1] == 1) x--;
      }
      //오른쪽 확인
      else if(x < 99 && ladder[y][x+1] == 1){
        while(x < 99 && ladder[y][x+1] == 1) x++;
      }
      //없다면 위로 이동
      y--;
    }
    return x;
  }
}