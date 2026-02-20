import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int[] num = new int[10];
      for(int i=0; i<5; i++){
        int n = Integer.parseInt(br.readLine());
        num[n]++;
      }
      
      for(int i=0; i<10; i++){
        if(num[i]%2 == 1){
          System.out.println(i);
          return;
        }
      }
    }
}