import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      boolean[] check = new boolean[n+1];
      
      for(int i=0; i<n-1; i++){
        int num = Integer.parseInt(st.nextToken());
        check[num] = true;
      }
      
      for(int i=1; i<n+1; i++){
        if(!check[i]){
          System.out.println(i);
          return;
        }
      }
    }
}