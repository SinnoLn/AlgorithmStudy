import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int maxNum = 0;
      int y = 0;
      int x = 0;
      
      for(int i=0; i<9; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<9; j++){
          int n = Integer.parseInt(st.nextToken());
          if(maxNum<n){
            maxNum = n;
            y = i;
            x = j;
          }
          else if(maxNum == n){
            y = Math.max(y, i);
            x = Math.max(x, j);
          }
        }
      }
      
      System.out.println(maxNum);
      System.out.println((y+1) +" "+ (x+1));
  }
}