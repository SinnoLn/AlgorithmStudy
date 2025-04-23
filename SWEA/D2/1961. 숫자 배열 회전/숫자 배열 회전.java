import java.util.*;
import java.io.*;

//N*N 행렬의 90도 180도 270도 회전한 모양 출력
public class Solution{
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for(int test = 1; test<=t; test++){
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3*n];
        int[][] original = new int[n][n];
        
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            original[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        int[][] rot90 = rotate(original, 90);
        int[][] rot180 = rotate(original, 180);
        int[][] rot270 = rotate(original, 270);
        
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
            arr[i][j] = rot90[i][j];
            arr[i][j+n] = rot180[i][j];
            arr[i][j+2*n] = rot270[i][j];
          }
        }
        
        System.out.println("#"+test);
        for(int i=0; i<n; i++){
          for(int j=0; j<3*n; j++){
            if(j != 0 && j%n == 0) System.out.print(" ");
            System.out.print(arr[i][j]);
          }
          System.out.println();
        }
      }
    }
    static int[][] rotate(int[][] arr, int degree){
      int[][] rotate;
      int n = arr.length;
      int m = arr[0].length;
      
      switch(degree){
        case 90:
        case 270:
            rotate = new int[m][n];
            break;
        case 180:
            rotate = new int[n][m];
            break;
        default:
            throw new IllegalArgumentException();
      }
      
      for(int i=0; i<rotate.length; i++){
        for(int j=0; j<rotate[0].length; j++){
          switch(degree){
            case 90:
              rotate[i][j] = arr[n-1-j][i];
              break;
            case 180:
              rotate[i][j] = arr[n-1-i][m-1-j];
              break;
            case 270:
              rotate[i][j] = arr[j][m-1-i];
              break;
          }
        }
      }
      return rotate;
    }
}