import java.util.*;
import java.io.*;

public class Solution {
    static Map<String, Integer> stringToInt = new HashMap<>();
    static Map<Integer, String> intToString = new HashMap<>();
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      initialize();
      
      for(int t=1; t<=test; t++){
        int[] numList = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        String output = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++){
          String stringNum = st.nextToken();
          int n = stringToInt.get(stringNum);
          numList[n]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
          while(numList[i]>0){
            sb.append(intToString.get(i)).append(" ");
            numList[i]--;
          }
        }
        System.out.println(output);
        System.out.println(sb.toString());
      }
  }
  
  static void initialize(){
    stringToInt.put("ZRO" , 0);
    stringToInt.put("ONE" , 1);
    stringToInt.put("TWO" , 2);
    stringToInt.put("THR" , 3);
    stringToInt.put("FOR" , 4);
    stringToInt.put("FIV" , 5);
    stringToInt.put("SIX" , 6);
    stringToInt.put("SVN" , 7);
    stringToInt.put("EGT" , 8);
    stringToInt.put("NIN" , 9);
    
    intToString.put(0, "ZRO");
    intToString.put(1, "ONE");
    intToString.put(2, "TWO");
    intToString.put(3, "THR");
    intToString.put(4, "FOR");
    intToString.put(5, "FIV");
    intToString.put(6, "SIX");
    intToString.put(7, "SVN");
    intToString.put(8, "EGT");
    intToString.put(9, "NIN");
  }
}