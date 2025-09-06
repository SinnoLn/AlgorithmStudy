import java.util.*;
import java.io.*;

public class Main {
    //수열은 사전순으로 증가
    //순서 고려 (visited 필요 없음)
    //순열
    static int n,m;
    static int[] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      nums = new int[n];
      visited = new boolean[n];
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        nums[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(nums);
      StringBuilder sb = new StringBuilder();
      
      backtrack(0, sb);
  }
  
  static void backtrack(int idx, StringBuilder sb){
    if(idx == m){
      System.out.println(sb.toString());
      return;
    }
    
    for(int i=0; i<n; i++){
      if(visited[i]) continue;
      visited[i] = true;
      String sNum = Integer.toString(nums[i]);
      sb.append(sNum).append(" ");
      backtrack(idx+1, sb);
      visited[i] = false;
      sb.setLength(sb.length()-(sNum.length()+1));
    }
  }
}