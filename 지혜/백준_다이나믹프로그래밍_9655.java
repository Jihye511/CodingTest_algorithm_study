import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=1;
        for(int i =4; i<=n; i++){
            dp[i] = Math.min(dp[i-3],dp[i-1]) +1;
        }
        if(dp[n]%2 ==0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }

    }
}
