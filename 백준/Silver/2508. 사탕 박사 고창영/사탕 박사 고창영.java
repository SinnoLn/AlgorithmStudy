import java.util.*;
import java.io.*;


//400*400 = 160000
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      for(int test = 0; test<n; test++){
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        char[][] info = new char[a][b];
        
        for(int i=0; i<a; i++){
          String s = br.readLine();
          for(int j=0; j<b; j++) info[i][j] = s.charAt(j);
          while(s.contains(">o<")){
            int p = s.indexOf(">o<");
            s = s.substring(0,p) + "000" + s.substring(p+3,s.length());
            ans++;
          }
        }
        
        for(int i=0; i<b; i++){
          StringBuilder sb = new StringBuilder();
          for(int j=0; j<a; j++){
            sb.append(info[j][i]);
          }
          String s = sb.toString();
          while(s.contains("vo^")){
            int p = s.indexOf("vo^");
            s = s.substring(0,p) +"000"+ s.substring(p+3,s.length());
            ans++;
          }
        }
        
        System.out.println(ans);
      }
  }
}