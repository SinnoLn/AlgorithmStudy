import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        
        double avg = 0.0;
        int[] student = new int[num];
        for(int j=0; j<num; j++){
          int grade = Integer.parseInt(st.nextToken());
          student[j] = grade;
          
          avg+=grade;
        }
        
        avg/=num;
        
        int highGrade = 0;
        for(int j=0; j<num; j++){
          if(student[j]>avg) highGrade++;
        }
        
        System.out.printf("%.3f",(double)highGrade/num*100);
        System.out.print("%");
        System.out.println();
      }
    }
}