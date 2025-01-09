package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b22943 { 
    private static List<Integer> combiResults = new ArrayList<>();
    private static List<Integer> answers = new ArrayList<>();
    private static int M, K;
    private static List<Integer> primes = new ArrayList<>();
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        // 1. 서로 다른 두개의 소수의 합으로 나타낼 수 있어야 한다.
        // 2. M으로 나누어떨어지지 않을 때까지 나눈 수가 두 개의 소수의 곱인 경우
        //    - 두 개의 소수가 서로 같아도 됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());   // 자릿수
        M = Integer.parseInt(st.nextToken());

        generatePrimes(99999);
        combi(0, new ArrayList<>());

        for (int num : combiResults) {
            if (checkFirst(num) && checkSecond(num)) {
                answers.add(num);
            }
        }

        System.out.println(answers.size());
    }

    private static void generatePrimes(int max) {
        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

    // 두 소수의 합으로 숫자를 나타낼 수 있는지 검사
    private static boolean checkFirst(int num) {
        for (int prime : primes) {
            if (prime > num / 2) break; // 첫 번째 소수가 num의 절반을 넘으면 더 이상 탐색할 필요 없음
            int other = num - prime;
            if (other != prime && isPrime[other]) return true; // 두 번째 소수는 첫 번째 소수와 다르며, 소수여야 함
        }
        return false;
    }

    // M으로 나눈 후 남은 수가 두 소수의 곱인지 검사
    private static boolean checkSecond(int num) {
        while (num % M == 0) num /= M;
        for (int prime : primes) {
            if (prime * prime > num) break;
            if (num % prime == 0 && isPrime[num / prime]) return true;
        }
        return false;
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

    // 숫자 조합을 생성
    private static void combi(int start, List<Integer> current) {
        if (current.size() == K) {
            if (current.get(0) != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < current.size(); i++) {
                    sb.append(current.get(i));
                }
                combiResults.add(Integer.parseInt(sb.toString()));
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!current.contains(i)) {
                current.add(i);
                combi(i, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
