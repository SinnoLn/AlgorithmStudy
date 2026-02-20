import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int i=0; i<15; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<15; j++){
          char c = st.nextToken().charAt(0);
          if(c == 'w'){
            System.out.println("chunbae");
            return;
          }
          else if(c == 'b'){
            System.out.println("nabi");
            return;
          }
          else if(c == 'g'){
            System.out.println("yeongcheol");
            return;
          }
        }
      }
    }
}