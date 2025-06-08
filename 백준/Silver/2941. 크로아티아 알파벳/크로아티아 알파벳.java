import java.util.*;
import java.io.*;

public class Main {
    static List<String> words = Arrays.asList("c=","c-","dz=","d-","lj","lj","nj","s=","z=");
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      
      StringBuilder sb = new StringBuilder(s);
      
      int ans = 0;
      for(String word : words){
        while(sb.toString().contains(word)){
          int index = sb.toString().indexOf(word);
          sb.delete(index, index+word.length());
          sb.insert(index, "0");
          ans++;
        }
      }
      for(int i=0; i<sb.length(); i++){
        if(sb.charAt(i) != '0') ans++;
      }
      System.out.println(ans);
  }
}