import java.util.*;
import java.io.*;

public class Main {

    public static String S, T;
    public static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        T = br.readLine();

        dfs(T);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static void dfs(String t) {
        int lenT = t.length();
        if (lenT == S.length()) {
            if (t.equals(S)) {
                answer = 1;
            }
            return;
        }
        if (t.endsWith("A")) {
            dfs(t.substring(0, lenT - 1));
        }
        if (t.startsWith("B")) {
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}