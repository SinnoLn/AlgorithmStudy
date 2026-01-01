import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       
       for(int i=0; i<n; i++){
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         String s1 = st.nextToken();
         String s2 = st.nextToken();
         
         if(isPossible(s1,s2)) System.out.println("Possible");
         else System.out.println("Impossible");
       }
  }
  
  static boolean isPossible(String a, String b){
    if(a.length() != b.length()) return false;
    int[] n1 = new int[26];
    int[] n2 = new int[26];
    
    for(int i=0; i<a.length(); i++){
      n1[a.charAt(i)-'a']++;
      n2[b.charAt(i)-'a']++;
    }
    
    for(int i=0; i<26; i++){
      if(n1[i] != n2[i]) return false;
    }
    
    return true;
  }
}