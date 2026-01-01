import java.util.*;
import java.io.*;

//애너그램이 되기 위한 제거해야하는 최소 개수의 문자
//아무 위치 상관x
//소문자
//각각의 길이 1000 안넘음
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s1 = br.readLine();
      String s2 = br.readLine();
      
      int[] n1 = new int[26];
      int[] n2 = new int[26];
      
      for(int i=0; i<s1.length(); i++){
        n1[s1.charAt(i)-'a']++;
      }
      
      for(int i=0; i<s2.length(); i++){
        n2[s2.charAt(i)-'a']++;
      }
      
      
      int ans = 0;
      for(int i=0; i<26; i++){
        if(n1[i] != n2[i]){
          ans+=Math.abs(n1[i]-n2[i]);
        }
      }
      
      System.out.println(ans);
  }
}