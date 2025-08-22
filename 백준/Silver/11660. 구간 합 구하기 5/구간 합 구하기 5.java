import java.util.*;
import java.io.*;

//1024*1024 = 약 105만
//최대 10만번 테스트
//누적합 문제
public class Main {
  static int[][] map;
  static int[][] ps;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      map = new int[n][n];
      ps = new int[n+1][n+1];
      
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
           ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + map[i - 1][j - 1];
        }
      }
      
      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        
        int sum = ps[y2][x2] - ps[y1 - 1][x2] - ps[y2][x1 - 1] + ps[y1 - 1][x1 - 1];
        bw.write(String.valueOf(sum));
        bw.write('\n');
      }
      
      bw.flush();
      bw.close();
      br.close();
  }
}