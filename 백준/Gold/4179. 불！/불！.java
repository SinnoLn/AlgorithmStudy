import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    static int jy, jx, ans;
    static Deque<int[]> fire = new ArrayDeque<>();

    static int[][] fireDist;
    static final int INF = 1000001;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        fireDist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(fireDist[i], INF);
        }

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                char c = input.charAt(j);
                if(c=='J'){
                    jy = i;
                    jx = j;
                    map[i][j] = 0;
                }
                else if(c=='F'){
                    fire.add(new int[]{i,j});
                    map[i][j] = 2;
                    fireDist[i][j] = 0;
                }
                else if(c=='#') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }
        
        //불의 이동시간 미리 계산
        precomputeFireDist();
        //지훈 움직임
        move();

        if(ans != 0) System.out.println(ans);
        else System.out.println("IMPOSSIBLE");
    }

    static void move(){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{jy, jx, 0});
        visited[jy][jx] = true;

        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int cy = cur[0];
            int cx = cur[1];
            int t  = cur[2];
            
            //이동 불가
            if (fireDist[cy][cx] <= t) {
                continue;
            }

            if(cy==0 || cx==0 || cy==(n-1) || cx==(m-1)){
                ans = t + 1;
                return;
            }

            for(int dir=0; dir<4; dir++){
                int ny = dy[dir] + cy;
                int nx = dx[dir] + cx;

                if(ny<0 || nx<0 || ny>=n || nx>=m) continue;
                if(map[ny][nx] == 1) continue;
                if(visited[ny][nx]) continue;

                int arrive = t + 1;
                //도착시간에 불이 이미 있거나 같이 오면
                if (fireDist[ny][nx] <= arrive) continue;
                visited[ny][nx] = true;
                dq.add(new int[]{ny, nx, arrive});
            }
        }
    }

    // 지훈이와 불이 동시에 이동하는게 아닌
    // 고정된 불의 시간 먼저 계산
    static void precomputeFireDist(){
        Deque<int[]> fq = new ArrayDeque<>(fire);

        while(!fq.isEmpty()){
            int[] cur = fq.poll();
            int fy = cur[0];
            int fx = cur[1];
            int ft = fireDist[fy][fx];

            for(int dir=0; dir<4; dir++){
                int ny = fy + dy[dir];
                int nx = fx + dx[dir];

                if(ny<0 || nx<0 || ny>=n || nx>=m) continue;
                if(map[ny][nx] == 1) continue;
                if(fireDist[ny][nx] <= ft + 1) continue;

                fireDist[ny][nx] = ft + 1;
                fq.add(new int[]{ny, nx});
            }
        }
    }
}
