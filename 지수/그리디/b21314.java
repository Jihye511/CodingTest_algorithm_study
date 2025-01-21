package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b21314 {
    private static final int INTEGER_M = 1;
    private static final int INTEGER_K = 5;
    private static final int INTEGER_0 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'K') {
                sb.append(ch);
                list.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            sb.append(ch);
        }
        if (sb.length() != 0) {
            list.add(sb.toString());
        }


        StringBuilder minSb = new StringBuilder();
        StringBuilder maxSb = new StringBuilder();
        for (String s : list) {
            if (s.equals("M")) {
                minSb.append(INTEGER_M);
                maxSb.append(INTEGER_M);
                continue;
            }

            if (s.equals("K")) {
                minSb.append(INTEGER_K);
                maxSb.append(INTEGER_K);
                continue;
            }

            String subS = s.substring(s.length() - 1);
            if (!subS.equals("K")) {
                minSb.append(INTEGER_M);
                for (int i = 0; i < s.length() - 1; i++) {
                    minSb.append(INTEGER_0);
                }

                for (int i = 0; i < s.length(); i++) {
                    maxSb.append(INTEGER_M);
                }
                continue;
            }
            getMax(s, maxSb);
            getMin(s, minSb);
        }
        System.out.println(maxSb.toString());
        System.out.println(minSb.toString());
    }

    private static void getMax(String s, StringBuilder maxSb) {
        maxSb.append(INTEGER_K);
        for (int i = 0; i < s.length() - 1; i++) {
            maxSb.append(INTEGER_0);
        }
    }

    private static void getMin (String s, StringBuilder minSb) {
        StringBuilder sb = new StringBuilder();
        String subS = s.substring(0, s.length() - 1);
        sb.append(INTEGER_M);
        for (int i = 0; i < subS.length() - 1; i++) {
            sb.append(INTEGER_0);
        }
        sb.append(INTEGER_K);

        minSb.append(sb);
    }


}
