import java.util.*;
import java.io.*;

//n은 1이상 10이하 
//파스칼 삼각형출력
//1
//1 1
//1 2 1
//1 3 3 1
public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      //그냥 10까지 전부 구해놓고 출력 
      //dp로 구하면 될듯
      int[][] triangle = new int[11][11]; // 0based-index 고려
      triangle[1][1] = 1;
      //기저 조건 생성
      for(int i=2; i<=10; i++){
        triangle[i][1] = 1;
        triangle[i][i] = 1;
      }
      
      //삼각형 만들기 시작
      for(int i=3; i<=10; i++){
        for(int j=2; j<i; j++){
          triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
        }
      }
      
      for(int test = 1; test<=t; test++){
        int n = Integer.parseInt(br.readLine());
        System.out.println("#"+test);
        for(int i=1; i<=n ;i++){
          for(int j=1; j<=i; j++){
            System.out.print(triangle[i][j] + " ");
          }
          System.out.println();
        }
      }
  }
}