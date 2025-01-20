package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 뺄셈을 기준으로 문자열을 나눈다.
        String[] subStr = str.split("-");

        int ans = 0;
        for (int i = 0; i < subStr.length; i++) {
            int sum = 0;

            // 덧셈을 기준으로 문자열을 나눈다.
            String[] addStr = subStr[i].split("\\+");

            for (int j = 0; j < addStr.length; j++) {
                sum += Integer.parseInt(addStr[j]);
            }
            if (i == 0) {
                ans = sum;
                continue;
            }
            ans -= sum;
        }

        System.out.println(ans);
    }
}
