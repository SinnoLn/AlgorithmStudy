import java.util.*;

class Main {
    public static int n, m, k;
    public static int[][] mushroom;
    public static boolean[][] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        mushroom = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) mushroom[i][j] = sc.nextInt();
        }
        
        int ans = BFS();

        if(ans < 0 || ans == m) {
            System.out.println("IMPOSSIBLE");   
        }
        else {
            System.out.println("POSSIBLE");
            System.out.println(ans);
        } 
        
        sc.close();
    }
    public static int BFS(){
        Queue<int[]> q = new LinkedList<>();
        int dy[] = {0,0,1,-1};
        int dx[] = {1,-1,0,0};
        int remainedSpore = m;
        int areaSize = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] || mushroom[i][j] == 1) continue;
                areaSize = 1;
                visited[i][j] = true;
                q.add(new int[] {i, j});

                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    int y = curr[0];
                    int x = curr[1];

                    for(int dir=0; dir<4; dir++){
                        int ny = y + dy[dir];
                        int nx = x + dx[dir];

                        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                        if(visited[ny][nx] || mushroom[ny][nx] == 1) continue;

                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                        areaSize++;
                    }
                }
                int neededSpore = (areaSize/k);
                if(areaSize%k != 0) neededSpore++;

                remainedSpore-=neededSpore;
                if(remainedSpore < 0) break;
            }
        }
        return remainedSpore;
    }
}