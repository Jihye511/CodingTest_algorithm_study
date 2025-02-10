package 백트래킹_0210;
import java.io.*;
import java.util.*;
public class BOJ_15666_N과M {
    static int N,M;
    static int[] num;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            num[i]= Integer.parseInt(st.nextToken());
        }
        arr = new int[M];
        Arrays.sort(num);
        dfs(0,0);
        System.out.println(sb);
    }
    public static void dfs(int start, int depth){
        if(depth ==M){
            for(int v : arr){
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before =0;
        for(int i =start; i<N; i++){
            if(before != num[i]){
                before = num[i];
                arr[depth] = num[i];
                dfs(i, depth+1);
            }
        }
    }
}
