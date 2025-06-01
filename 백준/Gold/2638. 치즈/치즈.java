import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] cheese;
    static int dy[] = {0,0,1,-1};
    static int dx[] = {-1,1,0,0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      
      cheese = new int[n][m];
      
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++){
          cheese[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      //// 로직 시작
      int ans = 0;
      while(true){
        List<int[]> melting = new ArrayList<>();
        visited = new boolean[n][m];
        bfs(0,0);
        
        for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
            if(cheese[i][j] == 0) continue;
            if(checkOut(i,j)>1) melting.add(new int[]{i,j});
          }
        }
        if(melting.isEmpty()) break;
      
        for(int[] list : melting){
          cheese[list[0]][list[1]] = 0;
        }
        ans++;
      }
      System.out.println(ans);
  }
  
  //치즈 내부 공기 파악 
  //가장자리는 치즈가 없음
  static void bfs(int startY, int startX){
    
    Queue<int[]>q = new LinkedList<>();
    
    q.add(new int[]{startY, startX});
    visited[startY][startX] = true;

    while(!q.isEmpty()){
      int[] curr = q.poll();
      int y = curr[0];
      int x = curr[1];
      
      for(int dir=0; dir<4; dir++){
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(visited[ny][nx] || cheese[ny][nx] == 1) continue;
        q.add(new int[]{ny, nx});
        visited[ny][nx] = true;
      }
    }
  }
  
  //상,하,좌,우 탐색시 2개이상 0인지 체크
  static int checkOut(int y, int x){
    int cnt = 0;
    for(int dir=0; dir<4; dir++){
      int ny = y + dy[dir];
      int nx = x + dx[dir];
      if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
      if(visited[ny][nx] && cheese[ny][nx] == 0) cnt++;
    }
    return cnt;
  }
}