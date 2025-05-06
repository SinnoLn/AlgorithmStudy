import java.util.*;
import java.io.*;

public class Solution {
    static int[][] sudoku = new int[9][9];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        for(int i=0; i<9; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<9; j++){
            sudoku[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        int ans = 0;
        if(isSudoku()) ans = 1;
        
        System.out.println("#"+t+" "+ans);
      }
    }
      
      static boolean isSudoku(){
        //행열 탐색
        for(int i=0; i<9; i++){
          int[] num1 = new int[10]; //행
          int[] num2 = new int[10]; //열
          for(int j=0; j<9; j++){
            num1[sudoku[i][j]]++;
            num2[sudoku[j][i]]++;
            if(num1[sudoku[i][j]] > 1 || num2[sudoku[j][i]] > 1) return false;
          }
        }
        
        //3*3 탐색 (총 9번)
        for(int i=0; i<9; i+=3){
          for(int j=0; j<9; j+=3){
            
            int[] num = new int[10];
            for(int y=i; y<i+3; y++){
              for(int x=j; x<j+3; x++){
                num[sudoku[y][x]]++;
                if(num[sudoku[y][x]]>1) return false;
              }
            }
          }
        }
        
        return true;
      }
}