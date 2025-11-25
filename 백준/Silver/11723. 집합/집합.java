import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      //300만
      
      int m = Integer.parseInt(br.readLine());
      boolean[] bitmask = new boolean[21];
      for(int i=0; i<m; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String op = st.nextToken();
        if(op.equals("all")){
          Arrays.fill(bitmask,true);
        }
        else if(op.equals("empty")){
          Arrays.fill(bitmask,false);
        }
        else{
          int n = Integer.parseInt(st.nextToken());
          if(op.equals("add")) bitmask[n] = true;
          else if(op.equals("remove")) bitmask[n] = false;
          else if(op.equals("check")){
            int tmp = bitmask[n] ? 1 : 0;
            bw.write(tmp+"\n");
          }
          else if(op.equals("toggle")) bitmask[n] = !bitmask[n];
        }
      }
      
      bw.flush();
      bw.close();
      br.close();
  }
}