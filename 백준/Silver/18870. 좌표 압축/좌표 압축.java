import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int num : list) set.add(num);

        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            map.put(sorted.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(list[i])).append(" ");
        }
        System.out.println(sb);
    }
}
