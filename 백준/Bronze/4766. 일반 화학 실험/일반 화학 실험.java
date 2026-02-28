import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      double memo = Double.parseDouble(br.readLine());
      
      while(true){
        double num = Double.parseDouble(br.readLine());
        if((int)num == 999) break;
        
        double diff = num-memo;
        memo = num;
        
        System.out.printf("%.2f\n",diff);
      }
    }
}