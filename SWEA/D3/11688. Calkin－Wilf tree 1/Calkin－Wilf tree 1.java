import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int rootA = 1;
        int rootB = 1;
        
        String dir = br.readLine();
        for(int i=0; i<dir.length(); i++){
          int currdir = dir.charAt(i);
          
          if(currdir == 'R') rootA = rootA + rootB;
          else rootB = rootA + rootB;
        }
        System.out.println("#"+t+" "+rootA +" "+rootB);
      }
  }
}