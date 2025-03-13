import java.util.*;
import java.io.*;

class Main {
    public static final int MAX_SIZE = 19;
    public static int[][] go = new int[MAX_SIZE][MAX_SIZE];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<MAX_SIZE; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<MAX_SIZE; j++){
                go[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (go[i][j] == 0) continue;
                int[] result = Check_go(i, j);
                if (result != null) {
                    System.out.println(go[i][j]);
                    System.out.println(result[0] + " " + result[1]);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    public static int[] Check_go(int y, int x) {
        int[] dy = {1,0,1,-1};
        int[] dx = {0,1,1,1};
        int stone = go[y][x];

        for(int i=0; i<4; i++){
            int cnt = 1;
            int ny = y;
            int nx = x;
            int startY = y, startX = x;
            
            while(true){
                ny+=dy[i];
                nx+=dx[i];
                
                if(ny >= MAX_SIZE || nx >= MAX_SIZE || ny < 0 || nx < 0) break;
                if(go[ny][nx] != stone) break;
                cnt++;

                if (nx < startX || (nx == startX && ny < startY)) {
                    startX = nx;
                    startY = ny;
                }
            }

            ny = y;
            nx = x;
            while(true){
                ny-=dy[i];
                nx-=dx[i];

                if(ny >= MAX_SIZE || nx >= MAX_SIZE || ny < 0 || nx < 0) break;
                if(go[ny][nx] != stone) break;
                cnt++;

                if (nx < startX || (nx == startX && ny < startY)) {
                    startX = nx;
                    startY = ny;
                }
            }

            if (cnt == 5) {
                return new int[]{startY + 1, startX + 1};
            }
        }
        return null;
    }
}