import java.util.*;
import java.io.*;

//최대 길이 10만
//3의 배수 -> 모든 자리의 합 3의 배수
//0의 배수 -> 0이 포함
public class Main {
    static int ans = -1;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String input = br.readLine();
      int sum = 0;
      boolean check = false;
      int[] word = new int[input.length()];

      for(int i=0; i<input.length(); i++){
        int num = input.charAt(i)-'0';
        word[i] = num;
        sum+=num;
        if(!check){
          if(num == 0) check = true;
        }
      }
      
      if(check && sum%3==0){
        Arrays.sort(word);
        StringBuilder sb = new StringBuilder();
        for(int i=word.length-1; i>=0; i--) sb.append(word[i]);
        System.out.println(sb.toString());
      }
      else System.out.println(-1);
  }
}