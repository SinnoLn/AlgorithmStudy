import java.util.*;
import java.io.*;

//갈 수 있는곳 0
//장애물은 1
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int r,c,k,currDir;
    static List<int[]> dir = new ArrayList<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      map = new int[r][c];
      visited = new boolean[r][c];
      
      k = Integer.parseInt(br.readLine());
      for(int i=0; i<k; i++){
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        map[y][x] = 1;
      }
      
      st = new StringTokenizer(br.readLine());
      int sr = Integer.parseInt(st.nextToken());
      int sc = Integer.parseInt(st.nextToken());
      
      //방향 설정
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<4; i++){
        int d = Integer.parseInt(st.nextToken());
        if(d == 1) dir.add(new int[]{-1,0});
        else if(d == 2) dir.add(new int[]{1,0});
        else if(d == 3) dir.add(new int[]{0,-1});
        else if(d == 4) dir.add(new int[]{0,1});
      }
  
      visited[sr][sc] = true;
      int ans[] = move(sr, sc);
      System.out.println(ans[0] + " " + ans[1]);
  }
  //움직일 수 없다의 기준이 뭐지?
  static int[] move(int sy, int sx){
    int cnt = 0;
    currDir = 0;
    while(true){
      int ny = sy + dir.get(currDir)[0];
      int nx = sx + dir.get(currDir)[1];
      
      if(cnt > 3) return new int[] {sy, sx};
      if(ny < 0 || nx < 0 || ny >= r || nx >= c || visited[ny][nx] || map[ny][nx] == 1){
        currDir = (currDir+1)%4; //방향 전환
        cnt++;
        continue;
      } 
      cnt = 0;
      visited[ny][nx] = true;
      sy = ny;
      sx = nx;
    }
  }
}