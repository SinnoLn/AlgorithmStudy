import java.util.*;
import java.io.*;

//불만도의 합 최소라
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] student = new int[n];
      for(int i=0; i<n; i++){
        student[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(student);
      
      long ans = 0;
      for(int i=0; i<n; i++){
        ans += Math.abs(student[i] - (i+1));
      }
      System.out.println(ans);
  }
}