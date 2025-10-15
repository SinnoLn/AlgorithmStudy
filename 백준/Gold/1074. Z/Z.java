import java.util.*;
import java.io.*;

public class Main {
    static int n,r,c;
    static int idx;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      
      //2의 n승
      int size = 1<<n;
      idx = 0;
      solve(0,0,size);
  }
  
  static void solve(int y, int x, int size){
    if(size == 1){
      System.out.println(idx);
      return;
    }
    
    int h = size/2;
    int q = 0;
    
    if(r>=y+h) q+=2;
    if(c>=x+h) q+=1;
    
    idx += q*(h*h);
    
    //각 사분면에서의 위치
    if(q==0) solve(y,x,h);
    else if(q==1) solve(y,x+h,h);
    else if(q==2) solve(y+h,x,h);
    else solve(y+h,x+h,h);
  }
}