import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      int[] change = {50000,10000,5000,1000,500,100,50,10};
      
      for(int t=1; t<=test; t++){
        int price = Integer.parseInt(br.readLine());
        int[] ans = new int[8];
        
        for(int i=0; i<change.length; i++){
          ans[i] = price/change[i];
          price%=change[i];
        }
        
        System.out.println("#"+t);
        for(int a : ans){
          System.out.print(a + " ");
        }
        System.out.println();
      }
  }
}