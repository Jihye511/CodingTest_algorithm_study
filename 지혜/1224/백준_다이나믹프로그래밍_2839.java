import java.io.*;
import java.util.*;


public class Main {
    static int[] dp = new int[5001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Arrays.fill(dp,5000);
        dp[0] = 0;
        if(N>=3) dp[3]=1;
        if(N>=5) dp[5]=1;

        for(int i =6;i<=N; i++){
            if(dp[i-3] != 5000) dp[i] = Math.min(dp[i],dp[i-3] +1);
            if(dp[i-5] != 5000) dp[i] = Math.min(dp[i],dp[i-5]+1);
        }
        System.out.println(dp[N]==5000? -1 : dp[N]);


    }

}
