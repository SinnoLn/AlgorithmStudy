import java.util.*;
import java.io.*;

//3.3 이상
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      List<String> list = Arrays.asList("F","F","D0","D+","C0","C+","B0","B+","A0","A+");
      double totalScore = 0.0;
      double totalCredit = 0.0;
      
      for(int i=0; i<20; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        double point = Double.parseDouble(st.nextToken());
        String grade = st.nextToken();
        
        if(grade.equals("P")) continue;
        totalScore += point*(list.indexOf(grade)*0.5);
        totalCredit += point;
      }
       System.out.printf("%.6f\n", totalScore / totalCredit);
  }
}