import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      int[] devide = {2,3,5,7,11};
      
      //1000만인데 별로 안큼
      for(int test=1; test<=t; test++){
        //소인수분해 해야함
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[5];
        
        for(int i=0; i<devide.length; i++){
          while(n%devide[i] == 0){
            n/=devide[i];
            cnt[i]++;
          }
        }
        System.out.print("#"+test+" ");
        for(int num : cnt){
          System.out.print(num+" ");
        }
        System.out.println();
      }
  }
}