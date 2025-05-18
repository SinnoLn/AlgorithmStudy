import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      StringBuilder sb = new StringBuilder();
      int cnt = n/4;
      while(cnt>0){
        sb.append("long").append(" ");
        cnt--;
      }
      sb.append("int");
      System.out.println(sb.toString());
  }
}