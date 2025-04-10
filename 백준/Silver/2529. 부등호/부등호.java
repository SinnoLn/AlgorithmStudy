import java.util.*;
import java.io.*;

class Main {
    public static boolean[] visited;
    public static char[] A;
    public static int k;
    public static List<String> results = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new char[k];
        visited = new boolean[10];
        
        for(int i=0; i<k; i++) A[i] = st.nextToken().charAt(0);

        dfs("", 0);

        Collections.sort(results);
        System.out.println(results.get(results.size()-1));
        System.out.println(results.get(0));
    }
    public static void dfs(String curr, int depth){
        if(depth == (k+1)){
            results.add(curr);
            return;
        }
        for(int i=0; i<10; i++){
            if(visited[i])continue;
            
            if(depth == 0 || isValid(curr.charAt(depth-1)-'0', i, A[depth-1])){
                visited[i] = true;
                dfs(curr+i, depth+1);
                visited[i] = false;
            }
        }
    }
    public static boolean isValid(int a, int b, char sign){
        if(sign == '<') return  a < b;
        else return a > b;
    }
}