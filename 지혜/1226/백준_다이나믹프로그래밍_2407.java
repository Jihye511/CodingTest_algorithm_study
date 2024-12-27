import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int n,m;
    static BigInteger[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new BigInteger[n+1][m+1];
        System.out.println(combi(n,m));
    }
    public static BigInteger combi(int N,int M){
        if(N == M || M ==0){
            return BigInteger.ONE;
        }
       if(dp[N][M] !=null){
            return dp[N][M];
        }
       dp[N][M] = combi(N-1,M-1).add(combi(N-1,M));
        return dp[N][M];
    }
}
