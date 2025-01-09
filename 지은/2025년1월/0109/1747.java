import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = N; i < 999999999; i++) {
            if (isPrime(i) && isPalindrom(i)) {
                bw.write(String.valueOf(i));
                break;
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean isPalindrom(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        return sb.toString().equals(sb.reverse().toString());
    }

    private static boolean isPrime(int num) {
        if (num == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
