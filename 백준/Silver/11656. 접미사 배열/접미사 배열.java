import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      String s = br.readLine();
      List<String> list = new ArrayList<>();
      
      for(int i=0; i<s.length(); i++){
        String tmp = s.substring(i,s.length());
        list.add(tmp);
      }
      
      Collections.sort(list);
      
      for(String ss : list) {
        bw.write(ss);
        bw.write('\n');
      }
      
      bw.flush();
      bw.close();
    }
}