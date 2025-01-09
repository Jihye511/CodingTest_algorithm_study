package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int monkey = Integer.parseInt(st.nextToken());
        int dog = Integer.parseInt(st.nextToken());

        if (monkey == dog) {
            System.out.println(0);
            return;
        }

        double interval = dog - monkey;

        double a = Math.sqrt(interval);

        if (a - (int) a > 0) {
            if (interval - Math.pow((int) a, 2) <= (int) a) {
                System.out.println(2 * (int) a - 1 + 1);
            } else {
                System.out.println(2 * (int) a - 1 + 2);
            }
        } else {
            System.out.println(2 * (int) a - 1);
        }
    }
}
