import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      char[][] arr = new char[n][m];
      
      for(int i=0; i<n; i++){
        arr[i] = br.readLine().toCharArray();
      }
      
      int[] dy = {0,1,0,-1};
      int[] dx = {1,0,-1,0};
      
      for(int y=0; y<n; y++){
        for(int x=0; x<m; x++){
          if(arr[y][x] == 'X')continue;
          
          int cnt = 0;
          for(int dir=0; dir<4; dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny<0 || nx<0 || ny >= n || nx >= m) continue;
            if(arr[ny][nx] == '.') cnt++;
          }
          //뚫린길이 1개 이하면 막다른길 
          if(cnt <= 1){
            System.out.println(1);
            return;
          }
        }
      }
      System.out.println(0);
  }
}