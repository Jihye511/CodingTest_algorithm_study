import java.util.*;
import java.io.*;

public class Main {

    public static int N ;
    public static int[] number;
    public static int[] operator = new int[4];
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        sb.append(MAX).append("\n").append(MIN);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {

                operator[i]--;
                if(i == 0) dfs(num + number[idx], idx + 1);
                else if(i == 1) dfs(num - number[idx], idx + 1);
                else if(i == 2) dfs(num * number[idx], idx + 1);
                else dfs(num / number[idx], idx + 1);
                operator[i]++;
            }
        }
    }
}