import java.util.*;
import java.io.*;

public class Main {
    static int[][] apart;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int tc = Integer.parseInt(br.readLine());
      
      apart = new int[15][15];
      for(int i=1; i<15; i++) apart[0][i] = i;
      for(int i=1; i<15; i++){
        for(int j=1; j<15; j++){
            apart[i][j] = apart[i-1][j] + apart[i][j-1];
        }
      }
      
      for(int t=0; t<tc; t++){
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(apart[k][n]);
      }
  }
}