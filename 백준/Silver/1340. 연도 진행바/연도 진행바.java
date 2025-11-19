import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] input = br.readLine().split(" ");
      
      //이번 해 몇 % 지났는지
      List<String> MONTH = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
      List<Integer> MONTHDAY = Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31);
      
      int month = MONTH.indexOf(input[0])+1;
      
      input[1] = input[1].substring(0,input[1].length()-1);
      int day = Integer.parseInt(input[1]);
      int year = Integer.parseInt(input[2]);
      int hour = Integer.parseInt(input[3].substring(0,2));
      int minute = Integer.parseInt(input[3].substring(3,5));
      
      double leftTime = 0.0;
      double allTime = 0.0;
      boolean leapYear = isLeapYear(year);
      
      //총 시간 초로 구하기
      for(int i=1; i<=12; i++){
        if(i==2 && leapYear) allTime += 29*60L*60*24; 
        else allTime += MONTHDAY.get(i-1)*60L*60*24;
      }
      
      //지난 시간 초로 구하기
      for(int i=1; i<=month-1; i++){
        if(i==2 && leapYear) leftTime += 29*60L*60*24; 
        else leftTime += MONTHDAY.get(i-1)*60L*60*24;
      }

      leftTime += hour*60L*60+minute*60+(day-1)*60L*60*24;

      double percent = leftTime/allTime*100.0;
      System.out.println(percent);
      
  }
  
  static boolean isLeapYear(int year){
    if(year%400 == 0) return true;
    if(year%4==0 && year%100 != 0) return true;
    return false;
  }
}