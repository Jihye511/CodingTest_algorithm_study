package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (A < B) {
            cnt++;
            if (B % 2 == 0) {
                B /= 2;
                continue;
            }
            String tmp = String.valueOf(B);
            if (tmp.substring(tmp.length()-1).equals("1")) {
                tmp = tmp.substring(0, tmp.length() - 1);
                B = Integer.parseInt(tmp);
                continue;
            }
            break;
        }

        if (A == B) {
            System.out.println(cnt + 1);
        } else {
            System.out.println(-1);
        }

    }
}
