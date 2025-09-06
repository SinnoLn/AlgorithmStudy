import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else map.put(num, 1);
        }
      
        Collections.sort(list);
      
        StringBuilder sb = new StringBuilder();
        backtrack(0,sb);
    }
  
    static void backtrack(int idx, StringBuilder sb){
        if(idx == m){
            System.out.println(sb.toString());
            return;
        }
    
        int prev = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int v = list.get(i);
            if (v == prev) continue;
            Integer cnt = map.get(v);
            if (cnt == null || cnt == 0) continue;

            map.put(v, cnt - 1);
            int len = sb.length();
            sb.append(v).append(" ");
            backtrack(idx+1, sb);
            sb.setLength(len);
            map.put(v, cnt);

            prev = v;
        }
    }
}
