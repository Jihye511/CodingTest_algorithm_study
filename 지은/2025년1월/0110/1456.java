import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int limit = (int) Math.sqrt(M) + 1;
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                long base = i;
                long power = base * base;
                while (power <= M) {
                    if (power >= N) {
                        count++;
                    }
                    if (M / base < power) break;
                    power *= base;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
