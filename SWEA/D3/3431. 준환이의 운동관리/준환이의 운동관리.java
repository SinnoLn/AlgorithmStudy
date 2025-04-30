import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int test = Integer.parseInt(br.readLine());
    
    for(int t=1; t<=test; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int u = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      
      System.out.println("#"+t+" "+calTime(l,u,x));
    }
  }
  static int calTime(int l, int u, int x){
    if(x>u) return -1;
    else if(x<l) return l-x;
    else return 0;
  }
}