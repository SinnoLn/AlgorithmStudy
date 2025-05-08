import java.util.*;
import java.io.*;

//n/10명 동일한 학점
public class Solution {
    static class Student{
      int idx;
      double grade;
      
      public Student(int idx, double grade){
        this.idx = idx;
        this.grade = grade;
      }
    };
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Student[] students = new Student[num];
        for(int i=0; i<num; i++){
          st = new StringTokenizer(br.readLine());
          int mid = Integer.parseInt(st.nextToken());
          int last = Integer.parseInt(st.nextToken());
          int assignment = Integer.parseInt(st.nextToken());
          
          students[i] = new Student(i+1, mid*(0.35) + last*(0.45) + assignment*(0.2));
        }
        Arrays.sort(students, (a, b) -> Double.compare(b.grade, a.grade));
        
        int index = 0;
        for(int i=0; i<num; i++){
          if(students[i].idx == k){
            index = i;
            break;
          }
        }
        
        int rankGroup = num / 10;
        System.out.println("#" + t + " " + grade[index / rankGroup]);
      }
  }
}