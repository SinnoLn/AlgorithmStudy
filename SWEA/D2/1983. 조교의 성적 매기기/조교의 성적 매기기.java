import java.util.*;
import java.io.*;

public class Solution {
  //먼저 정렬 후 인덱스 찾아서 구하기
  static class Student {
    int id;
    double grade;
    
    public Student(int id, double grade){
      this.id = id;
      this.grade = grade;
    }
  };
  static String[] grades = {"","A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for(int test = 1; test<=t; test++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Student[] students = new Student[n];
        
        for(int i=0; i<n; i++){
          st = new StringTokenizer(br.readLine());
          int mid = Integer.parseInt(st.nextToken());
          int fin = Integer.parseInt(st.nextToken());
          int task = Integer.parseInt(st.nextToken());
          
          students[i] = new Student(i+1,mid*(0.35) + fin*(0.45) + task*(0.2));
        }
        
        Arrays.sort(students, (a,b) -> Double.compare(b.grade, a.grade));
        for(int i=0; i<n; i++){
          if(students[i].id == k){
            System.out.println("#" + test + " " + grades[i / (n/10) + 1]);
          }
        }
      }
    }
}