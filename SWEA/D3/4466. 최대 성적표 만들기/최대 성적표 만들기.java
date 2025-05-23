import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++) {
    	  StringTokenizer st = new StringTokenizer(br.readLine());
    	  int n = Integer.parseInt(st.nextToken());
    	  int k = Integer.parseInt(st.nextToken());
    	  
    	  arr = new int[n];
    	  int ans = 0;
    	  st = new StringTokenizer(br.readLine());
    	  
    	  for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
    	  Arrays.sort(arr);
    	  for(int i=0; i<k; i++) {
    		  ans+=arr[n-1-i];
    	  }
    	  System.out.println("#"+t+" "+ans);
      }
  }
}
