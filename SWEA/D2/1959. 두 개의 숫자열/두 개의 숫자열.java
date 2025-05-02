import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) b[i] = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        if(n>m) ans = calMax(a,b);
        else ans = calMax(b,a);
        
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int calMax(int[] a, int[] b){
    int max = 0;
    for(int i=0; i<a.length-b.length+1; i++){
      int sum = 0;
      for(int j=0; j<b.length; j++){
        sum+=a[i+j]*b[j];
      }
      max = Math.max(sum, max);
    }
    return max;
  }
}