import java.util.*;
import java.io.*;

class Main {
    public static int n;
    public static int[] maze;
    public static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        maze = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) maze[i] = Integer.parseInt(st.nextToken());

        q.add(new int[]{0, 0});
        BFS();    
    }
    
    public static void BFS(){
        boolean visited[] = new boolean[n];

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int position = curr[0];
            int count = curr[1];

            if(position == (n-1)) {
                System.out.println(count);
                return;
            }

            if(visited[position]) continue;
            visited[position] = true;

            int maxJump = maze[position];
            for(int i=1; i<maxJump+1; i++){
                int next = position + i;
                if(next < n && !visited[next]){
                    q.add(new int[]{next, count + 1});
                }
            }
        }
        System.out.println(-1);
    }
}