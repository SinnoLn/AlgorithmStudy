import java.util.*;
import java.io.*;

public class Main {
  static class Info{
    int weight;
    int height;
    int cnt;
    
    public Info(int weight, int height, int cnt){
      this.weight = weight;
      this.height = height;
      this.cnt = cnt;
    }
  }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      Info info[] = new Info[n];
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        info[i] = new Info(w,h,0);
      }
      
      for(int i=0; i<n; i++){
        int sum = 0;
        for(int j=0; j<n; j++){
          if(i==j) continue;
          if(info[i].weight<info[j].weight && info[i].height<info[j].height) sum++;
        }
        info[i].cnt = sum+1;
      }
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<n; i++){
        sb.append(info[i].cnt).append(" ");
      }
      System.out.println(sb.toString());
  }
}