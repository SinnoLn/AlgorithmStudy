import java.util.*;
import java.io.*;

public class Solution {
    static char[] nums;
    static int answer, maxSwap;
    static Set<String> visited = new HashSet<>();
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        nums = new char[num.length()];
        answer = 0;
        visited.clear();
        
        maxSwap = Integer.parseInt(st.nextToken());
        for(int i=0; i<num.length(); i++) nums[i] = num.charAt(i);
        
        dfs(0,num);
        System.out.println("#"+t+" "+answer);
      }
  }
  
  static void dfs(int cnt, String curr){
    if(cnt == maxSwap){
      answer = Math.max(answer, Integer.parseInt(curr));
      return;
    }
  
    String key = curr +","+ cnt;
    if(visited.contains(key)) return;
    visited.add(key);
    
    char[] chars = curr.toCharArray();
    for(int i=0; i<chars.length-1; i++){
      for(int j=i+1; j<chars.length; j++){
        swap(chars, i,j);
        dfs(cnt+1, new String(chars));
        swap(chars, j,i);
      }
    }
  }
  
  static void swap(char arr[], int i, int j){
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}