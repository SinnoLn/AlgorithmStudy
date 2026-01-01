import java.util.*;
import java.io.*;

//여학생 0
//남학생 1
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      int[] list = new int[13];
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        
        int sex = Integer.parseInt(st.nextToken());
        int grade = Integer.parseInt(st.nextToken());
        
        if(sex == 0) list[grade]++;
        else list[6+grade]++;
      }
      
      //계산
      int ans = 0;
      for(int i=1; i<13; i++){
        ans+=list[i]/k;
        if(list[i]%k != 0) ans++;
      }
      
      System.out.println(ans);
  }
}