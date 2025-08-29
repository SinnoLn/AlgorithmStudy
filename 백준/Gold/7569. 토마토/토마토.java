import java.util.*;
import java.io.*;


// 3차원 bfs
//최대 100만개의 토마토
//아래부터 위로
//1 익음 0 안익음 -1 토마토 없음
//new int[405][405][405] 256mb 넘는 기준
//저장될때부터 0이 없으면 0
//다 해도 전부 못 익으면 -1
public class Main {
    static int[][][] box;
    static int n,m,h,unripe;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());
      
      box = new int[h][n][m];

      for(int i=0; i<h; i++){
        for(int j=0; j<n; j++){
          st = new StringTokenizer(br.readLine());
          for(int k=0; k<m; k++){
            box[i][j][k] = Integer.parseInt(st.nextToken());
            if(box[i][j][k] == 1) q.add(new int[]{i,j,k,0});
            if(box[i][j][k] == 0) unripe++;
          }
        }
      }
      
      if(unripe == 0){
        System.out.println(0);
        return;
      }
      
      int ans = bfs();
    
      if(unripe != 0) System.out.println(-1);
      else System.out.println(ans);
  }
  
  static int bfs(){
    
    int maxDay = 0;
    
    while(!q.isEmpty()){
      int[] curr = q.poll();
      int z = curr[0];
      int y = curr[1];
      int x = curr[2];
      int day = curr[3];
      
      maxDay = Math.max(maxDay, day);
      
      for(int dir=0; dir<6; dir++){
        int nz = z + dz[dir];
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if(ny<0 || nx<0 || nz<0 || ny>=n || nx>=m || nz>=h) continue;
        if(box[nz][ny][nx] != 0 ) continue;
        box[nz][ny][nx] = 1;
        
        q.add(new int[]{nz,ny,nx,day+1});
        unripe--;
      }
    }
    return maxDay;
  }
}