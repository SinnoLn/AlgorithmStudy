import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      int arr[] = new int[n];
      int lcs[] = new int[n];
      int lds[] = new int[n];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
      for(int i=0; i<n; i++){
        lcs[i] = 1;
        lds[i] = 1;
      }
      
      for(int i=0; i<n-1; i++){
        for(int j=i+1; j<n; j++){
          if(arr[i] < arr[j]) {
            lcs[j] = Math.max(lcs[j], lcs[i]+1);
          }
        }
      }
      
      for(int i=n-1; i>0; i--){
        for(int j=i-1; j>-1; j--){
          if(arr[i] < arr[j]) {
            lds[j] = Math.max(lds[j], lds[i]+1);
          }
        }
      }
      
      int ans = 0;
      for(int i=0; i<n; i++){
        ans = Math.max(ans, lds[i]+lcs[i]-1);
      }
      System.out.println(ans);
  }
}