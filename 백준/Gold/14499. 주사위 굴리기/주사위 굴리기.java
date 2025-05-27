import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[] dice = {0,0,0,0,0,0,0};
    //1.위, 2.뒤, 3.오른쪽, 4.왼쪽, 5.앞, 6,아래
    //동쪽
    //1->3, 3->6, 6->4, 4->1
    //서쪽
    //1->4, 4->6, 6->3, 3->1
    //남쪽
    //1->5, 5->6, 6->2, 2->1
    //북쪽
    //1->2, 2->6, 6->5, 5->1
    static int n,m,y,x,k;
    static int dy[] = {0,0,0,-1,1};
    static int dx[] = {0,1,-1,0,0};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      x = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      
      map = new int[n][m];
      
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<m; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<k; i++){
        int op = Integer.parseInt(st.nextToken());
        moveDice(op);
      }
      
      bw.flush();
      bw.close();
      br.close();
  }
  static void moveDice(int op) throws IOException{
    int ny = y + dy[op];
    int nx = x + dx[op];
    
    if(ny<0 || nx<0 || ny>=n || nx>=m) return;
    
    //주사위 이동
    int tmp = 0;
    if(op == 1){ //동
      tmp = dice[1];
      dice[1] = dice[3];
      dice[3] = dice[6];
      dice[6] = dice[4];
      dice[4] = tmp;
    }
    else if(op == 2){ //서
      tmp = dice[1];
      dice[1] = dice[4];
      dice[4] = dice[6];
      dice[6] = dice[3];
      dice[3] = tmp;
    }
    else if(op == 3){ //남
      tmp = dice[1];
      dice[1] = dice[5];
      dice[5] = dice[6];
      dice[6] = dice[2];
      dice[2] = tmp;
    }
    else if(op ==4){ //북
      tmp = dice[1];
      dice[1] = dice[2];
      dice[2] = dice[6];
      dice[6] = dice[5];
      dice[5] = tmp;
    }
    
    if(map[ny][nx] == 0) map[ny][nx] = dice[6];
    else {
      dice[6] = map[ny][nx];
      map[ny][nx] = 0;
    }
    bw.write(dice[1]+"\n");
    y = ny;
    x = nx;
  }
}