import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      //0층부터 10억층
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        int floor = 0;
        boolean check = false;
        for(int i=1; i<n+1; i++){
          if(floor+i == p) check = true;
          floor+=i;
        }
        if(check) floor--;
        System.out.println(floor);
      }
  }
}