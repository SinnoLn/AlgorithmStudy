import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      int[] changes = {50000,10000,5000,1000,500,100,50,10};
      for(int test = 1; test<=t; test++){
        int n = Integer.parseInt(br.readLine());
        int[] changeCnt = new int[8];
        
        for(int i=0; i<8; i++){
          if(n>=changes[i]){
          changeCnt[i] = n/changes[i];
          n%=changes[i];
          }
        }
        System.out.println("#"+test);
        for(int i : changeCnt){
          System.out.print(i + " ");
        }
        System.out.println();
      }
    }
}