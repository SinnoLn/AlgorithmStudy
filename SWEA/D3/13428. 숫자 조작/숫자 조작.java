import java.util.*;
import java.io.*;

public class Solution {
    static int[] num;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        String s = br.readLine();
        int n = s.length();
        num = new int[n];
        int max = Integer.parseInt(s);
        int min = Integer.parseInt(s);
        
        for(int i=0; i<n; i++) num[i] = s.charAt(i)-'0';
        
        for(int i=0; i<n-1; i++){
          for(int j=i+1; j<n; j++){
            swap(i,j);
            
            if(num[0] != 0){
              long tmp = 0;
              for(int len=0; len<n; len++){
                tmp+=num[len];
                tmp*=10;
              }
              tmp/=10;
              max = Math.max(max,(int)tmp);
              min = Math.min(min,(int)tmp);
            }
            swap(j,i);
          }
        }
        
        System.out.println("#"+t+" "+min + " "+max);
      }
  }
  
  static void swap(int y, int x){
    int tmp = num[x];
    num[x] = num[y];
    num[y] = tmp;
  }
}