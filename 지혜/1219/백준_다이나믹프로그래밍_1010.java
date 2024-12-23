import java.io.*;
import java.util.*;
public class Main {
    static int T;
    static int N,M;
    static int[][] dp= new int[30][30];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while(T-->0){
            st= new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            combi(M,N);
            sb.append(dp[M][N]).append("\n");
        }
        System.out.println(sb);
    }
    public static int combi(int m, int n){
        if(dp[m][n]>0){
            return dp[m][n];
        }
        if(m==n || n==0){
            return dp[m][n] =1;
        }
        return dp[m][n] = combi(m-1,n-1)+ combi(m-1,n);
    }
}
