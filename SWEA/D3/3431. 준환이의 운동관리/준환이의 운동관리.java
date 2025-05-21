import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()); //이상
        int u = Integer.parseInt(st.nextToken()); //이하
        int x = Integer.parseInt(st.nextToken()); //운동시간
        
        int remainingTime = 0;
        if(x < l) remainingTime = l-x;
        else if(x > u) remainingTime = -1;
        System.out.println("#"+t+" "+remainingTime);
      }
  }
}