import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class Main {
    static int[] dp = new int[21];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        pibo(n);
        System.out.println(dp[n]);
    }
    public static int pibo(int n){
        if(n==0 || n==1){
            return dp[n]=n;
        }
        return dp[n] = pibo(n-1)+pibo(n-2);
    }
}
