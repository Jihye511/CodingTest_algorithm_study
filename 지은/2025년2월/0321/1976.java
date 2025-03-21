import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                if(st.nextToken().equals("1")) {
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] route = new int[M];
        for(int i=0; i<M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(check(route) ? "YES" : "NO");
        bw.flush();
        bw.close();

    }

    static boolean check(int[] arr) {
        int p = find(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(p != find(arr[i])) return false;
        }
        return true;
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }
}
