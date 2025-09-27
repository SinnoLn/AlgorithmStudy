import java.util.*;
import java.io.*;


public class Main {
  static class Cake{
    int x;
    int y;
    int z;
    
    public Cake(int x, int y, int z){
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      Cake[] cakes = new Cake[3];
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
        
      cakes[0] = new Cake(a,b,c);
      
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      
      cakes[2] = new Cake(a,b,c);
      
      a = cakes[2].x - cakes[0].z; 
      b = cakes[2].y / cakes[0].y;
      c = cakes[2].z - cakes[0].x;
      
      cakes[1] = new Cake(a,b,c);
      System.out.println(cakes[1].x + " " + cakes[1].y + " " + cakes[1].z);
  }
}