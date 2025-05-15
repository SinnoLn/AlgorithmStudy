import java.util.*;
import java.io.*;

//조합 7c3
public class Solution {
    static int[] arr;
    static int n,r;
    static Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      n = 7;
      r = 3;
      
      for(int t=1; t<=test; t++){
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(0,0,0);
        List<Integer> list = new ArrayList<>(set);
        System.out.println("#"+t+" "+list.get(4));
        set.clear();
      }
  }
  
  static void dfs(int depth, int start, int sum){
    if(depth == r){
       set.add(sum);
       return;
    }
    
    for(int i=start; i<n; i++){
      dfs(depth+1, i+1, sum+arr[i]);
    }
  }
}