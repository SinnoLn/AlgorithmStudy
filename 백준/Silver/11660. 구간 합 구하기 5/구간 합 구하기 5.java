import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[][] arr = new int[n+1][n+1];
      
      long[][] prefix = new long[n+1][n+1];
      
      for(int i=1; i<n+1; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=1; j<n+1; j++){
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      // 누적합 로직
      for(int i=1; i<n+1; i++){
        for(int j=1; j<n+1; j++){
          prefix[i][j] = arr[i][j]
                       + prefix[i-1][j]
                       + prefix[i][j-1]
                       - prefix[i-1][j-1];
        }
      }
      
      StringBuilder sb = new StringBuilder();
      //계산
      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        
        long num = prefix[x2][y2] - prefix[x2][y1-1] - prefix[x1-1][y2] + prefix[x1-1][y1-1];
        sb.append(num).append('\n');
      }
      System.out.println(sb);
    }
}