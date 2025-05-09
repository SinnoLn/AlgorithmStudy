import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=1; t<=10; t++){
        int test = Integer.parseInt(br.readLine());
        String target = br.readLine();
        String original = br.readLine();
        int cnt = 0;
        
        StringBuilder sb = new StringBuilder(original);
        while(sb.indexOf(target) != -1){
          int index = sb.indexOf(target);
          sb.delete(index, index + target.length());
          cnt++;
        }
        
        System.out.println("#"+test+" "+cnt);
      }
  }
}