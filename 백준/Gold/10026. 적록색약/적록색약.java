import java.util.*;
import java.io.*;

class Main {
    public static int n;
    public static char[][] grid;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                grid[i][j] = line.charAt(j);
            }
        }

        int normal = bfs();

        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 'R') grid[i][j] = 'G';
            }
        }

        int blindness = bfs();
        
        System.out.println(normal + " " + blindness);
        
    }
    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        int dx[] = {0,0,1,-1};
        int dy[] = {-1,1,0,0};
        int area = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                visited[i][j] = true;
                area++;
                q.add(new int[]{i,j});

                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    int y = curr[0];
                    int x = curr[1];

                    for(int dir=0; dir<4; dir++){
                        int ny = y + dy[dir];
                        int nx = x + dx[dir];

                        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                        if(visited[ny][nx] || grid[y][x] != grid[ny][nx]) continue;
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
        return area;
    }
}