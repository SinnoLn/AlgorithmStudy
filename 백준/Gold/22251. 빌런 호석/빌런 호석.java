import java.util.*;
import java.io.*;

//시뮬레이션?
//브루트 포스
public class Main {
    static int[][] bitcheck = {
        {1,1,1,1,1,1,0},
        {0,1,1,0,0,0,0},
        {1,1,0,1,1,0,1},
        {1,1,1,1,0,0,1},
        {0,1,1,0,0,1,1},
        {1,0,1,1,0,1,1},
        {1,0,1,1,1,1,1},
        {1,1,1,0,0,0,0},
        {1,1,1,1,1,1,1},
        {1,1,1,1,0,1,1}
    };
    static int n,k,p,x;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken()); //n 이하의 수 (최대 100만 미만)
      k = Integer.parseInt(st.nextToken()); //총 k개의 패널
      p = Integer.parseInt(st.nextToken()); //최대 반전 LED 수 
      x = Integer.parseInt(st.nextToken()); //멈춘 층 (최대 100만 미만)
      
      /*
       이진법
      */
      
      int ans = 0;
      int[] curr = changeToArray(x);
      
      for(int i=1; i<=n; i++) {
        if(i == x) continue;
        if(isPossible(i, curr)) ans++;
      }
      
      System.out.println(ans);
    }
    
    static int[] changeToArray(int target){
      int[] arr = new int[k];
      for(int i=k-1; i>=0; i--){
        arr[i] = target%10;
        target/=10;
      }
      return arr;
    }
    
    static boolean isPossible(int target, int[] curr){
      int[] target_arr = changeToArray(target);
      int diff = 0;
      
      for(int i=0; i<k; i++){
        for(int j=0; j<7; j++){
          if(bitcheck[curr[i]][j] != bitcheck[target_arr[i]][j]) diff++;
        }
      }
      
      if(diff<=p) return true;
      else return false;
    }
}