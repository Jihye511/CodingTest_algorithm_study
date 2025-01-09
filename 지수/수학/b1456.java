package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        boolean[] X = new boolean[10000001];
        for (int i = 2; i < Math.sqrt(X.length); i++) {
            if (!X[i]) {
                for (int j = i + i; j < X.length; j += i) {
                    X[j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 2; i < X.length; i++) {
            if (!X[i]) {
                long now = i;
                while ((double) i <= (double) B / (double) now) {
                    if ((double) i >= (double) A / (double) now) {
                        ans++;
                    }
                    now *= i;
                }
            }
        }
        System.out.println(ans);

    }
}
