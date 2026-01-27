import java.util.*;
import java.io.*;

// 본인과 푼 문제 수 차이가 X 보다 작거나 같은 사람만
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      
      int ans = 0;
      
      for(int i=a; i<=b; i++){
        if((k-x)<=i && (k+x)>=i) ans++;
      }
      
      if(ans == 0) System.out.println("IMPOSSIBLE");
      else System.out.println(ans);
  }
}