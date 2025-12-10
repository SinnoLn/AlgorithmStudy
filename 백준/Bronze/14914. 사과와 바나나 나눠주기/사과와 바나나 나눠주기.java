import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      int end = a>b?b:a;
      
      for(int i=1; i<=end; i++){
        if(a%i==0 && b%i==0){
          bw.write(i + " " + a/i + " " + b/i);
          bw.write("\n");
        }
      }
      bw.flush();
      bw.close();
      br.close();
  }
}