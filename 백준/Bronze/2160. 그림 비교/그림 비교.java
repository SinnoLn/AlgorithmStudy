import java.util.*;
import java.io.*;


// n은 최대 50개
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      int[][] map = new int[n*5][7];
      
      // . = 0
      // X = 1
      for(int i=0; i<n*5; i++){
        String input = br.readLine();
        for(int j=0; j<7; j++){
          char c = input.charAt(j);
          if(c == '.') map[i][j] = 0;
          else map[i][j] = 1;
        }
      }
      
      //완전탐색으로 비교
      int[] ans = new int[2];
      int minDiff = Integer.MAX_VALUE;
      
      //0 5, 0 10, 0 15, 0 20, 5 10, 5 15, 5 20, 10 15, 10 20...
      for(int i=0; i<n*5-5; i+=5){
        for(int j=i+5; j<n*5; j+=5){
          
          int diff = 0;
          
          //실제 로직 시작
          for (int r = 0; r < 5; r++) {
              for (int c = 0; c < 7; c++) {
                  if (map[i + r][c] != map[j + r][c]) diff++;
              }
          }
          
          if(minDiff>diff){
            ans[0] = i;
            ans[1] = j;
            minDiff = diff;
          }
        }
      }
      
      System.out.println(((ans[0]/5)+1) + " " + ((ans[1]/5)+1));
  }
}