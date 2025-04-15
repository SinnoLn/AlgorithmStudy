import java.util.*;
import java.io.*;

// C(행)
// R(열)
// 1,1부터 시작 C,R까지
// 시계방향 회전해서 좌표 구하기
// 우 -> 하 -> 좌 -> 상

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dy = {0,1,0,-1};
        int[] dx = {1,0,-1,0};
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        boolean[][] visited = new boolean[n][m];
        
        int position = Integer.parseInt(br.readLine());
        
        int dir = 0;
        int y = 0;
        int x = 0;
        int num = 1;
        
        visited[0][0] = true;
        if(n*m < position){
            System.out.println(0);
            return;
        }
        
        if(position == 1){
            System.out.println(1 + " " + 1);
        }
        
        while(num<=position){
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]){
                dir = (dir+1)%4;
                continue;
            }
            
            num++;
            visited[ny][nx] = true;   
            y = ny;
            x = nx;
            
            if(num == position){
                System.out.println((y+1) + " " + (x+1));
                return;
            }
        }
    }
}