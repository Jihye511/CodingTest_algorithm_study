import java.util.*;
import java.io.*;

public class Main {
    static int K, M;
    static int[] nums;
    static boolean[] visited, notPrime, primeSum, primeMult;
    static int answer;
    static int Max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Max = (int) Math.pow(10, K);

        notPrime = new boolean[Max];
        primeSum = new boolean[Max];
        primeMult = new boolean[Max];

        nums = new int[K];
        visited = new boolean[10];
        answer = 0;
        primeCheck();
        makeSum();
        makeMult();

        perm(0, 0);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void primeCheck() {
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i < Max; i++) {
            if (!notPrime[i]) {
                for (int j = i + i; j < Max; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }

    private static void makeSum() {
        for (int i = 2; i < Max; i++) {
            if (notPrime[i]) continue;

            for (int j = i + 1; j < Max; j++) {
                if (notPrime[j]) continue;
                if (i + j >= Max) break;
                primeSum[i + j] = true;
            }
        }
    }

    private static void makeMult() {
        for (int i = 2; i < Max; i++) {
            if (notPrime[i]) continue;

            for (int j = i; j < Max; j++) {
                if (notPrime[j]) continue;

                long num = (long) i * (long) j;
                if (num >= Max) break;

                primeMult[(int) num] = true;
            }
        }
    }

    private static void perm(int cnt, int num) {
        if (cnt == K) {
            if (primeSum[num]) {
                int temp = num;
                while (temp % M == 0) {
                    temp /= M;
                }
                if (primeMult[temp]) {
                    answer++;
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (cnt == K - 1 && i == 0) continue;

            if (visited[i]) continue;

            visited[i] = true;
            nums[cnt] = i;
            perm(cnt + 1, num + i * (int) Math.pow(10, cnt));
            visited[i] = false;
        }
    }
}
