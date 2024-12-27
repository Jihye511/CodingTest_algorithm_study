import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int n,T;
    static int[][] dp;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            n = Integer.parseInt(br.readLine());
            map = new int[2][n];
            dp = new int[2][n];
            for(int i=0; i<=1; i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = map[0][0];

            dp[1][0] = map[1][0];
            int max = Math.max(dp[0][0], dp[1][0]);
            for(int i =1; i<n;i++){
                if(i==1){
                    dp[0][i] = map[0][i] +map[1][0];
                    dp[1][i] = map[1][i] + map[0][0];
                    max = Math.max(dp[0][i], dp[1][i]);
                    continue;
                }
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+map[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) +map[1][i];

                max = Math.max(max,Math.max(dp[1][i],dp[0][i]));
            }
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

}
