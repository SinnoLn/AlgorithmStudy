import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int idx = 1;
      while(true){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[3];
        for(int i=0; i<3; i++) num[i] = Integer.parseInt(st.nextToken());
        if(num[0] == 0) break;
        int a = num[0];
        int b = num[1];
        int c = num[2];
        String s = "";
        
        int tmp = 0;
        if(a == -1){
          tmp = c*c-b*b;
          s="a";
        } 
        else if(b == -1){
          tmp = c*c-a*a; 
          s="b";
        } 
        else{
          tmp = a*a+b*b;
          s="c";
        } 
        
        System.out.println("Triangle #"+idx);
        if(tmp <= 0) System.out.println("Impossible.");
        else {
          System.out.print(s+" = ");
          System.out.printf("%.3f\n",Math.sqrt(tmp));
        }
        System.out.println();
        idx++;
      }
  }
}