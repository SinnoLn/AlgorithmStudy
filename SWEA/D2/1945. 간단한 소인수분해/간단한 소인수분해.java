import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      int[] divide = {2,3,5,7,11};
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        
        System.out.print("#"+t+" ");
        for(int d : divide){
          int cnt = 0;
          while(n%d == 0){
            n/=d;
            cnt++;
          }
          System.out.print(cnt + " ");
        }
        System.out.println();
      }
  }
}