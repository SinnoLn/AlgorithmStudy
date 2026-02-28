import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=0; t<test; t++){
        int n = Integer.parseInt(br.readLine());
        int memo = 0;
        for(int i=1; i<101; i++){
          int late = i;
          if(n-(late+late*late)<0){
            System.out.println(memo);
            break;
          }
          memo = late;
        }
      }
    }
}