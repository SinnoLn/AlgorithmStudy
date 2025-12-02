import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      for(int i=0; i<t; i++){
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] food = new int[6];
        int sum = 0;
        for(int j=0; j<6; j++){
          food[j] = Integer.parseInt(st.nextToken());
          sum+=food[j];
        } 
        int day = 1;
        if(sum<=n){
          while(true){
            sum = 0;
            int[] tmpfood = new int[6];
            for(int f=0; f<6; f++){
              int tmp = f-1<0?5:f-1;
              tmpfood[f] = food[(f+1)%6]+food[tmp]+food[(f+3)%6]+food[f];
              sum+=tmpfood[f];
            }
            day++;
            if(sum>n) break;
            food = tmpfood;
          }
        }  
        System.out.println(day);
      }
  }
}