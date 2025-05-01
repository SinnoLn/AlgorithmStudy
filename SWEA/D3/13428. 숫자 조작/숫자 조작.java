import java.util.*;
import java.io.*;

public class Solution {
  static int[] arr;
  static int max, min;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        String s = br.readLine();
        int n = s.length();
        arr = new int[n];
        max = Integer.parseInt(s);
        min = Integer.parseInt(s);
        
        for(int i=0; i<n; i++){
          arr[i] = s.charAt(i)-'0';
        }
        
        //시작
        for(int i=0; i<n-1; i++){
          for(int j=i+1; j<n; j++){
            swap(i,j);
            StringBuilder sb = new StringBuilder();
            for(int digit : arr){
              sb.append(digit);
            }
            int num = Integer.parseInt(sb.toString());
            if(sb.charAt(0) != '0'){
              max = Math.max(max, num);
              min = Math.min(min, num);
            }
            swap(i,j);
          }
        }
        System.out.println("#"+t+" "+min + " " +max);
      }
  }
  
  static void swap(int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}