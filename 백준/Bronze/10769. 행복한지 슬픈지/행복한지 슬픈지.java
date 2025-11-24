import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] input = br.readLine().split(" ");
      
      int happy = 0;
      int sad = 0;
      
      for(int i=0; i<input.length; i++){
        while(input[i].contains(":-)") || input[i].contains(":-("))
        if(input[i].contains(":-)")){
          int pos = input[i].indexOf(":-)");
          input[i] = input[i].substring(0,pos) +"0"+input[i].substring(pos+3,input[i].length());
          happy++;
        }
        else if(input[i].contains(":-(")){
          int pos = input[i].indexOf(":-(");
          input[i] = input[i].substring(0,pos) +"0"+input[i].substring(pos+3,input[i].length());
          sad++;
        }
      }
      
      String ans = "";
      if(happy == 0 && sad == 0) ans = "none";
      else if(happy>sad) ans = "happy";
      else if(happy<sad) ans = "sad";
      else ans = "unsure";
      
      System.out.println(ans);
  }
}