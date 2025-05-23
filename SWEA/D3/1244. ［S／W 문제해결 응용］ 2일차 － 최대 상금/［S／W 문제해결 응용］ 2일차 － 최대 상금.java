import java.util.*;
import java.io.*;

//반드시 횟수만큼 교환 필요
//동일 위치 중복 교환 가능
public class Solution {
    static class State{
      int num;
      int cnt;
      
      public State(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
      }
    }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num = Integer.parseInt(st.nextToken());
        int swapCnt = Integer.parseInt(st.nextToken());
        
        int ans = bfs(num, swapCnt);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int bfs(int num, int swapCnt){
    Queue<State> q = new LinkedList<>();
    Set<String>[] visited = new HashSet[11];
    for (int i = 0; i <= 10; i++) visited[i] = new HashSet<>();
    
    int ans = 0;
    
    q.add(new State(num, 0));

    while(!q.isEmpty()){
      State state = q.poll();
      int currNum = state.num;
      int currCnt = state.cnt;

      String currStr = Integer.toString(currNum);
      if (visited[currCnt].contains(currStr)) continue;
      visited[currCnt].add(currStr);

      if(currCnt == swapCnt){
        ans = Math.max(ans, currNum);
        continue;
      }
      
      char[] digits = Integer.toString(currNum).toCharArray();
      
      for(int i=0; i<digits.length-1; i++){
        for(int j=i+1; j<digits.length; j++){
          swap(digits, i,j);
          
          int tmp = 0;
          for (char c : digits) {
            tmp = tmp * 10 + (c - '0');
          }
          
          q.add(new State(tmp,currCnt+1));
          swap(digits,i,j);
        }
      }
    }
    return ans;
  }
  
  static void swap(char[] arr, int i,int j){
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}