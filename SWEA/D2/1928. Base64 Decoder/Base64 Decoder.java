import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int test=1; test<=t; test++){
          String encoded = br.readLine();
          
          byte[] decodedBytes = Base64.getDecoder().decode(encoded);
          String decoded = new String(decodedBytes, "UTF-8");
          
          System.out.println("#" + test + " " + decoded);
        }
    }
}