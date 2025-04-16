import java.util.*;
import java.io.*;

public class Main {
    static int r;
    static int c;
    static char[][] map;
    static char[][] newMap;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      r = Integer.parseInt(st.nextToken()); //행
      c = Integer.parseInt(st.nextToken()); //열
      map = new char[r][c];
      newMap = new char[r][c];
      
      for(int i=0; i<r; i++){
        String s = br.readLine();
        for(int j=0; j<c; j++){
          map[i][j] = s.charAt(j);
        }
      }
      
      int maxX = Integer.MIN_VALUE;
      int maxY = Integer.MIN_VALUE;
      int minX = Integer.MAX_VALUE;
      int minY = Integer.MAX_VALUE;
      for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
          if(map[i][j] == '.') {
            newMap[i][j] = '.';
            continue;
          }
          if(checkOcean(i, j) < 3){
            newMap[i][j] = 'X';
            maxX = Math.max(maxX, j);
            maxY = Math.max(maxY, i);
            minX = Math.min(minX, j);
            minY = Math.min(minY, i);
          }
          else newMap[i][j] = '.';
        }
      }
      
      for(int i=minY; i<maxY+1; i++){
        for(int j=minX; j<maxX+1; j++){
          System.out.print(newMap[i][j]);
        }
        System.out.println();
      }
  }
  static int checkOcean(int y, int x){
      int dy[] = {0,0,1,-1};
      int dx[] = {1,-1,0,0};
      int ans = 0;
      
      //지도의 범위를 벗어나는 칸은 모두 바다
      for(int i=0; i<4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= r || nx >= c) ans++;
        else if(map[ny][nx] == '.') ans++;
      }
      return ans;
  }
}