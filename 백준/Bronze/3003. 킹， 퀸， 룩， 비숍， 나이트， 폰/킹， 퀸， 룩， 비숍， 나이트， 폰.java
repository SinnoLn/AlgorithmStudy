import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int[] chess = {1,1,2,2,2,8};
      int[] ans = new int[6];
      
      for(int i=0; i<6; i++){
        int num = Integer.parseInt(st.nextToken());
        ans[i] = chess[i] - num; 
      }
      
      for(int i : ans) System.out.print(i + " ");
  }
}