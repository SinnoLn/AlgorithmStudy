import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
      //수열 최대 100만
      StringBuilder sb = new StringBuilder();
      int n = Integer.parseInt(br.readLine());
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int[] nums = new int[n];
      int[] ans = new int[n];
      
      for(int i=0; i<n; i++){
        nums[i] = Integer.parseInt(st.nextToken());
      }
      
      Stack<Integer> stack = new Stack<>();
      for(int i=0; i<n; i++){
        while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
          ans[stack.pop()] = nums[i];
        }
      stack.push(i);
      }
      
      while(!stack.isEmpty()){
        ans[stack.pop()] = -1;
      }
      
      for(int i=0; i<n; i++){
        sb.append(ans[i]).append(" ");
      }
      System.out.println(sb.toString());
    }
}