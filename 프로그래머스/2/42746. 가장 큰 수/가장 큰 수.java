import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] sArr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) sArr[i] = Integer.toString(numbers[i]);
        Arrays.sort(sArr, (a,b) -> (b+a).compareTo(a+b));
        for(String t : sArr) answer+=t;
        
        if(sArr[0].equals("0")) return "0";
        return answer;
    }
}