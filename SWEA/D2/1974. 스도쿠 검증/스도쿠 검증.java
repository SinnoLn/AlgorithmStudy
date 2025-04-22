import java.util.*;
import java.io.*;

public class Solution {
  static int[][] sudoku = new int[9][9];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for(int test=0; test<t; test++){
        for(int i=0; i<9; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<9; j++){
              sudoku[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        int ans = 0;
        if(check()) ans = 1;
        System.out.println("#"+(test+1)+" "+ans);
      }
  }
  static boolean check(){
    //각 행부터 체크
    for(int i=0; i<9; i++){
      int[] num = new int[10];
      for(int j=0; j<9; j++){
        num[sudoku[i][j]]++;
        if(num[sudoku[i][j]] > 1) return false;
      }
    }
    
    //모든 열을 체크
    for(int i=0; i<9; i++){
      int[] num = new int[10];
      for(int j=0; j<9; j++){
        num[sudoku[j][i]]++;
        if(num[sudoku[j][i]] > 1) return false;
      }
    }
    
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