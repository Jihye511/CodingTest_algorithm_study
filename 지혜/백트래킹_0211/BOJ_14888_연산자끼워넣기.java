package 백트래킹_0211;
import java.io.*;
import java.util.*;
public class BOJ_14888_연산자끼워넣기 {
    static int N;
    static int []num;
    static int [] booho;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static char[] c = {'+','-','*','/'};
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        booho = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        for(int j =0; j<4; j++){
            booho[j] = Integer.parseInt(st.nextToken());
        }
        dfs(1,num[0]);
        System.out.println(max);
        System.out.println(min);

    }
    public static void dfs(int idx, int hap){
        if(idx == N){
            min = Math.min(min,hap);
            max = Math.max(max,hap);
            return;
        }

        for(int i =0;i<4; i++){
            if(booho[i] !=0) {
                booho[i]--;
                if (i == 0) {
                    dfs(idx + 1, hap + num[idx]);
                } else if (i == 1) {
                    dfs(idx + 1, hap - num[idx]);
                } else if (i == 2) {
                    dfs(idx + 1, hap * num[idx]);
                } else {
                    if (hap < 0) {
                        dfs(idx + 1, -(-hap / num[idx]));
                    } else {
                        dfs(idx + 1, hap / num[idx]);
                    }
                }

                booho[i]++;
            }
        }
    }
}
