import java.util.*;
import java.io.*;

public class Solution {
    static Set<Integer> set = new HashSet<>();
    static int[] array;
    static int n;
    static boolean[][] memo;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[n];
        memo = new boolean[101][100001];
        
        for(int i=0; i<n; i++) array[i] = Integer.parseInt(st.nextToken());
        dfs(0,0);
        System.out.println("#"+t+" "+set.size());
        set.clear();
      }
  }
  
  static void dfs(int idx, int sum){
    if(idx == n){
      set.add(sum);
      return;
    }
    if(memo[idx][sum]) return;
    memo[idx][sum] = true;
    
    dfs(idx+1, sum+array[idx]);
    dfs(idx+1, sum);
  }
}