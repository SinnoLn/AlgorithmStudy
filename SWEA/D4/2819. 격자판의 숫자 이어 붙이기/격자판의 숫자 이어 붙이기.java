import java.util.*;
import java.io.*;

public class Solution {
    static int[] dy = {0,1,0,-1}; 
    static int[] dx = {-1,0,1,0};
    static int[][] map;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test ; t++){
        map = new int[4][4];
        
        for(int i=0; i<4; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<4; j++){
            map[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        for(int i=0; i<4; i++){
          for(int j=0; j<4; j++){
            StringBuilder sb = new StringBuilder();
            sb.append((char)(map[i][j] + '0'));
            dfs(i,j,sb);
          }
        }
        System.out.println("#"+t+" "+set.size());
        set.clear();
      }
  }
  
  static void dfs(int y, int x, StringBuilder sb){
    if(sb.length() == 7){
      set.add(sb.toString());
      return;
    }
    
    for(int dir=0; dir<4; dir++){
      int ny = y + dy[dir];
      int nx = x + dx[dir];
      
      if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4) continue;
      char c = (char)(map[ny][nx] + '0');
      sb.append(c);
      dfs(ny,nx,sb);
      sb.setLength(sb.length() - 1);
    }
  }
}