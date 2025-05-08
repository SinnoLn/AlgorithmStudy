import java.util.*;
import java.io.*;

public class Solution {
    static int[] num;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++){
        int test = Integer.parseInt(br.readLine());
        num = new int[8];
        int minDivide = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<8; i++){
          num[i] = Integer.parseInt(st.nextToken());
          minDivide = Math.min(minDivide,num[i]/15);
        }
        for(int i=0; i<8; i++) num[i]-=(minDivide-1)*15;
        
        int idx = 0;
        int minus = 1;
        while(true){
          num[idx] -= minus;
          if(num[idx] <= 0){
            num[idx] = 0;
            break;
          }
          
          idx = (idx+1)%8;
          minus = (minus+1)%5;
          if(minus == 0) minus = 5;
        }
        
        idx++;
        System.out.print("#"+t+" ");
        for(int i=0; i<8; i++){
          System.out.print(num[idx] +" ");
          idx= (idx+1)%8;
        }
        System.out.println();
      }
  }
}