import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      nums = new int[n+1];
      for(int i=1; i<=n; i++) nums[i] = i;
      
      for(int k=0; k<m; k++){
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        
        reverse(i,j);
      }
      StringBuilder sb = new StringBuilder();
      for(int i=1; i<=n; i++) sb.append(nums[i]).append(" ");
      System.out.println(sb.toString());
  }
  
  static void reverse(int i, int j){
    while(i<j){
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
      i++;
      j--;
    }
  }
}