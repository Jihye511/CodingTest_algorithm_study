import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int distance = Y - X;

        if (distance == 0) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            return;
        }

        long n = (long) Math.sqrt(distance);
        long square = n * n;

        if (distance == square) {
            bw.write((2 * n - 1) + "\n");
        } else if (distance <= square + n) {
            bw.write((2 * n) + "\n");
        } else {
            bw.write((2 * n + 1) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
