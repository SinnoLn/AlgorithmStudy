import java.util.*;
import java.io.*;

public class Solution {
    static int[] box;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=1; t<=10; t++){
        int dump = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        box = new int[101];
        for(int i=0; i<100; i++){
          int height = Integer.parseInt(st.nextToken());
          box[height]++;
        }
        int[] ans = flat(dump);
        System.out.println("#"+t+" "+(ans[1]-ans[0]));
      }
  }
  
  static int[] flat(int dump){
    int left = 1;
    int right = 100;
    
    while(left<right){
      if(dump == 0) break;
      while(box[left] == 0) left++;
      while(box[right] == 0) right--;
      
      if(dump == 0) break;
      
      box[left]--;
      box[left+1]++;
      
      box[right]--;
      box[right-1]++;
      
      dump--;
    }
    
    while(box[left] == 0) left++;
    while(box[right] == 0) right--;
      
    return new int[] {left, right};
  }
}