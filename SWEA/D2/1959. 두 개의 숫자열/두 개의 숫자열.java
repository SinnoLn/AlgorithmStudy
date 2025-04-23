import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      for(int test=1; test<=t; test++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) arr2[i] = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        if(n>m) ans = checkMax(arr1, arr2);
        else ans = checkMax(arr2, arr1);
        
        System.out.println("#"+test +" "+ans);
      }
  }
  //완전탐색
  //b가 더 짧은거
  static int checkMax(int[] a, int[] b){
    int ans = 0;
    for(int i=0; i<a.length- b.length+1; i++){
      int tmp = 0;
      for(int j=i; j<i+b.length; j++){
        tmp+= a[j]*b[j-i];
    }
    ans = Math.max(ans, tmp);
  }
  return ans;
}
}