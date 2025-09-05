import java.io.*;
import java.util.*;

//이분 탐색
class Main {
    static class Info{
        int power;
        String name;

        public Info(int power, String name){
            this.power = power;
            this.name = name;
        }
    }
    static int n,m;
    static Info[] infos;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        infos = new Info[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            String n = st.nextToken();
            int p = Integer.parseInt(st.nextToken());

            infos[i] = new Info(p, n);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            bw.write(BinarySearch(num));
            bw.write('\n');
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }

    static String BinarySearch(int num){
        int l = 0;
        int r = n-1;
        int last = n-1;

        while(l<=r){
            int mid = (l+r)/2;

            if(num<=infos[mid].power){
                last = mid;
                r = mid-1;
            } 
            else {
                l = mid+1;
            }
        }

        return infos[last].name;
    }
}