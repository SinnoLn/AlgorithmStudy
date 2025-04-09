import java.util.*;
import java.io.*;

class Main {
    public static char[][] numberBoard = new char[5][5];
    public static Set<String> stringNums = new HashSet<>();
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                numberBoard[i][j] = st.nextToken().charAt(0);
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i,j,"", 0);
            }
        }
        System.out.println(stringNums.size());
    }

    public static void dfs(int y, int x, String curr, int depth){
        if(depth == 6) {
            stringNums.add(curr);
            return;
        }

        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny<0 || nx<0 || ny>4 || nx>4) continue;
            dfs(ny, nx, curr+numberBoard[ny][nx], depth+1);
        }
    }
}