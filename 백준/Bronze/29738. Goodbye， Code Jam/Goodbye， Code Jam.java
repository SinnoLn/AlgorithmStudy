import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++) {
        int n = Integer.parseInt(br.readLine());
        int round = 0;
        
        if(n>4500) round = 1;
        else if(n>1000) round = 2;
        else if(n>25) round = 3;
        else round = -1;
        
        if(round != -1) System.out.println("Case "+"#"+t+": Round "+round);
        else System.out.println("Case "+"#"+t+": World Finals");
      }
  }
}