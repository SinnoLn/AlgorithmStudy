import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int day = 0;
        
        if(n<c) System.out.println(1);
        else if(n%c==0) System.out.println(n/c);
        else System.out.println(n/c+1);
      }
  }
}