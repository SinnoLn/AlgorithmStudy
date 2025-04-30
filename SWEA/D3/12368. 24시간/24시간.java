import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int test = Integer.parseInt(br.readLine());
    
    for(int t=1; t<=test; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int current = Integer.parseInt(st.nextToken());
      int passed = Integer.parseInt(st.nextToken());
      
      System.out.println("#"+t+" "+(current+passed)%24);
    }
  }
}