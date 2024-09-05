import java.util.*;
import java.io.*;

public class backjoon15664{
    static int n,m;
    static int[] value;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());
        value = new int[n];
        arr = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);
        dfs(0,0);
        System.out.println(sb);

    }
    public static void dfs(int start,int depth){
        if(depth == m){
            for(int s : arr){
                sb.append(s).append(" ");
            }
            sb.append('\n');
            return;
        }

        int before =0;
        for(int i=start; i<n; i++){
            if(!visited[i]){
                if(before != value[i]){
                    visited[i] = true;
                    arr[depth] = value[i];
                    before = value[i];
                    dfs(i+1,depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}