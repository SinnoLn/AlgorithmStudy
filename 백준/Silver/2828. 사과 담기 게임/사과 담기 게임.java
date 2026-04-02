import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      int[] bucket = new int[2];
      bucket[0] = 1;
      bucket[1] = m;
      
      int j = Integer.parseInt(br.readLine());
      
      int ans = 0;
      for(int i=0; i<j; i++){
        int num = Integer.parseInt(br.readLine());
        
        //왼쪽
        if(num < bucket[0]){
          ans+=bucket[0] - num;
          bucket[0] = num;
          bucket[1] = num+m-1;
        }
        //오른쪽
        else if(num > bucket[1]){
          ans+=num-bucket[1];
          bucket[0] = num-m+1;
          bucket[1] = num;
        }
      }
      
      System.out.println(ans);
    }
}