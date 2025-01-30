package 완전탐색_0130;
import java.io.*;
import java.util.*;
public class 백준_12919 {
    static String T,S;
    static int ans = 0;
    public static void main(String[] args)throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        dfs(T);
        System.out.println(ans);


    }
    public static void dfs(String now){
        if (now.equals(S)) {
            ans = 1;
            return;
        }
        if (now.length() < S.length()) {
            return;
        }

        if (now.charAt(now.length() - 1) == 'A') {
            dfs(now.substring(0, now.length() - 1));
        }

        if (now.charAt(0) == 'B') {
            String reversed = new StringBuilder(now.substring(1)).reverse().toString();
            dfs(reversed);
        }
    }
}
