package 그리디_0121;
import java.io.*;
import java.util.*;
public class 백준_1931 {
    static int N;
    static int[][] map;
    public static  void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][2];
        for(int i =0; i<N ;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(map,(o1, o2) -> {
            if(o1[1]==o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        int endTime =map[0][1];
        int cnt=1;
        for(int i =1; i<N; i++){
            if(endTime<=map[i][0]){
                endTime =map[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
