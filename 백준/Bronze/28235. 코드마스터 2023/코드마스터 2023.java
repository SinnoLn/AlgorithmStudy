import java.util.*;
import java.io.*;

//원형 큐
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Map<String,String> map = new HashMap<>();
      
      map.put("SONGDO","HIGHSCHOOL");
      map.put("CODE","MASTER");
      map.put("2023","0611");
      map.put("ALGORITHM","CONTEST");
      
      String input = br.readLine();
      
      System.out.println(map.get(input));
    }
}