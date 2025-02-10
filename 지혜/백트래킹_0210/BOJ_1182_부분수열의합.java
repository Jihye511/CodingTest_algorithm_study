package 백트래킹_0210;
import java.io.*;
import java.util.*;

public class BOJ_1182_부분수열의합 {
    static int N,S;
    static int[] num;
    static int ans=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        st= new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            num[i] =Integer.parseInt(st.nextToken());
        }
        dfs(0,0,0);
        if(S ==0){
            System.out.println(ans-1);
        }else{
            System.out.println(ans);
        }


    }
    public static void dfs(int idx, int hap,int cnt){
        if(idx==N){
            if(hap == S){
                ans++;

            }
            return;
        }


        dfs(idx+1, hap+num[idx], cnt+1);
        dfs(idx+1,hap,cnt);
    }
}
