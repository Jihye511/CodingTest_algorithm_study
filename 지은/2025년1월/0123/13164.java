import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N-1];
        int temp = Integer.parseInt(st.nextToken());
        int cur = 0;
        for(int i=0; i<N-1; i++) {
            cur = Integer.parseInt(st.nextToken());
            arr[i] = cur - temp;
            temp = cur;
        }

        Arrays.sort(arr);
        int result = 0;
        for(int i = 0; i<N-K; i++) {
            result += arr[i];
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}