import java.util.*;
import java.io.*;

public class Solution {
    static int[][] arr;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t = 1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int[][] ans = new int[n][n*3];
        
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        int[][] arr90 = rotateArr(90, n, n);
        int[][] arr180 = rotateArr(180, n, n);
        int[][] arr270 = rotateArr(270, n, n);
        
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            ans[i][j] = arr90[i][j];
            ans[i][j+n] = arr180[i][j];
            ans[i][j+2*n] = arr270[i][j];
          }
        }
        
        System.out.println("#"+t);
        for(int i=0; i<n; i++){
          for(int j=0; j<3*n; j++){
            if(j != 0 && j%n == 0) System.out.print(" ");
            System.out.print(ans[i][j]);
          }
          System.out.println();
        }
      }
  }
  
  static int[][] rotateArr(int degree, int y, int x){
    int[][] tmp;
    switch (degree){
      case 90:
      case 270:
        tmp = new int[x][y];
        break;
      case 180:
        tmp = new int[y][x];
        break;
      default:
        throw new IllegalArgumentException("지원하지 않는 각도입니다." + degree);
    }
    
    for(int i=0; i<tmp.length; i++){
      for(int j=0; j<tmp[0].length; j++){
        if(degree == 90) tmp[i][j] = arr[x-j-1][i];
        else if(degree == 180) tmp[i][j] = arr[y-i-1][x-j-1];
        else tmp[i][j] = arr[j][y-i-1];
      }
    }
    return tmp;
  }
}