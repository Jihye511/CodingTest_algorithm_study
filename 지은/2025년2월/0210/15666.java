import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] arr, printArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        printArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i=0; i<M; i++) {
                sb.append(printArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for(int i=start; i<N; i++) {
            int now = arr[i];
            if(before != now) {
                before = now;
                printArr[depth] = arr[i];
                dfs(i, depth + 1);
            }

        }
    }
}