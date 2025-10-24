import java.util.*;
import java.io.*;

public class Main {
    static class Guitar{
      String word;
      int len;
      int sum;
      
      public Guitar(String word, int len, int sum){
        this.word = word;
        this.len = len;
        this.sum = sum;
      }
    }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      //커스텀 정렬
      //짧은거 
      //같으면 숫자합이 작은것
      //아니면 사전순 (숫자가 알파벳보다 사전순으로 작음)
      
      List<Guitar> list = new ArrayList<>();
      for(int i=0; i<n; i++){
        String s = br.readLine();
        int sum = 0;
        for(int j=0; j<s.length(); j++){
          if(s.charAt(j)>='A' && s.charAt(j)<='Z') continue;
          sum+=s.charAt(j)-'0';
        }
        list.add(new Guitar(s,s.length(),sum));
      }
      
      Collections.sort(list, (a,b)->{
        if(a.len != b.len) return a.len-b.len;
        else if(a.len == b.len && a.sum != b.sum) return a.sum-b.sum;
        else return a.word.compareTo(b.word);
      });
      
      for(Guitar g : list) System.out.println(g.word);
  }
}