import java.util.*;
import java.io.*;

public class Main {
    static class Grade {
      String name;
      int korea;
      int english;
      int math;
      
      public Grade(String name, int korea, int english, int math){
        this.name = name;
        this.korea = korea;
        this.english = english;
        this.math = math;
      }
    }
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      Grade[] grade = new Grade[n];
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        int korea = Integer.parseInt(st.nextToken());
        int english = Integer.parseInt(st.nextToken());
        int math = Integer.parseInt(st.nextToken());
        
        grade[i] = new Grade(name, korea, english, math);
      }
      
      Arrays.sort(grade, (a,b) -> {
        if(a.korea != b.korea) return b.korea - a.korea;
        if(a.english != b.english) return a.english - b.english;
        if(a.math != b.math) return b.math - a.math;
        return a.name.compareTo(b.name);
      });
      
      for(Grade g : grade){
        bw.write(g.name);
        bw.write('\n');
      }
      
      bw.flush();
      bw.close();
      br.close();
    }
}