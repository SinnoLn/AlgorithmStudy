import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int f = Integer.parseInt(st.nextToken());
      
      int x = 0;
      int y = 0;
      
      for(int i=-999; i<=999; i++){
        if((c-b*i)*d == (f-e*i)*a){
          y = i;
          break;
        } 
      }
      if(a == 0 && d == 0) x = 0;
      else if (a == 0) x = (f-e*y)/d;  
      else if (d == 0) x = (c-b*y)/a;
      else x= (c-b*y)/a; 
      System.out.println(x+" "+y);
  }
}