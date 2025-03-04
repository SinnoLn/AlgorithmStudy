import java.util.*;

class Main {
    public static int map[][];
    public static boolean visited[][];
    public static int[] dx = {0,0,1,-1,1,1,-1,-1};
    public static int[] dy = {1,-1,0,0,1,-1,-1,1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int w = sc.nextInt();
            int h = sc.nextInt();
    
            if(h == 0 && w == 0) break;
            map = new int[h][w]; 
            visited = new boolean[h][w];
            
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            
            int cnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(visited[i][j] || map[i][j] == 0) continue;
                    dfs(i,j,h,w);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
    public static void dfs(int y, int x, int h, int w){
        visited[y][x] = true;
        
        for(int i=0; i<8; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            
            if(ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
            if(visited[ny][nx] || map[ny][nx] == 0) continue;
            
            dfs(ny, nx, h, w);
        }
    }
}