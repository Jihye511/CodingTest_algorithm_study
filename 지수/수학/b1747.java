package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1747 {
    public static void main(String[] args) throws IOException {
        // N보다 크거나 같고
        // 소수이면서
        // 팰린드롬인 수 중에서
        // 가장 작은 수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (true) {
            if (isPrime(N) && checkPalindrome(N)) {
                break;
            }
            N += 1;
        }
        System.out.println(N);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPalindrome(int num) {
        String numToStr = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        for (int i = numToStr.length() - 1; i >= 0; i--) {
            char ch = numToStr.charAt(i);
            sb.append(ch);
        }
        if (numToStr.equals(sb.toString())) {
            return true;
        }
        return false;
    }
}
