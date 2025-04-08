import java.util.*;
import java.io.*;

class Main {
    public static int N;
    public static int S;
    public static int arr[];
    public static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        dfs(0,0,0);

        System.out.println(ans);
    }
    public static void dfs(int depth, int sum, int count){
        if(depth == N){
            if(sum == S && count > 0) ans++;
            return;
        }
        dfs(depth+1, sum + arr[depth], count+1);
        dfs(depth+1, sum, count);
    }
}