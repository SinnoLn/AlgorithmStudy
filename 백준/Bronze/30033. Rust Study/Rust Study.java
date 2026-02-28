import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int[] arr = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
      
      int ans = 0;
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        int num = Integer.parseInt(st.nextToken());
        if(num>=arr[i]) ans++;
      }
      
      System.out.println(ans);
    }
}