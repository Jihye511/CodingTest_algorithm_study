package 트리_0114;

import java.io.*;
import java.util.*;

public class 백준_9934
{
    static int n;
    static ArrayList<Integer>[] depth;
    static int[] input;
    static boolean[] visited;
    static int num;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = (int)Math.pow(2, n)-1;
        depth = new ArrayList[n+1];
        input = new int[num+1];
        visited = new boolean[num];
        for (int i = 0; i <= n; i++) {
            depth[i] = new ArrayList<>();
        }

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i =1; i<=num; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,1, num);

        for(int i =1; i<=n; i++) {
            for(int v : depth[i]) {
                System.out.print(v +" ");
            }
            System.out.println();
        }

    }
    public static void dfs(int d,int start, int end) {

        int mid = (start + end)/2;
        depth[d].add(input[mid]);
        if(d == n) return; //단말 노드

        dfs(d+1, start,mid-1); // 왼쪽
        dfs(d+1, mid+1, end); // 오른쪽
    }
}