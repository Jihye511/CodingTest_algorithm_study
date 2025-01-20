import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int count = 0;
        while(a < b) {
            count++;
            if(b%2 == 0) b /= 2;
            else if(b%10 == 1) b /= 10;
            else break;
        }

        bw.write(a==b ? String.valueOf(count+1) : "-1");
        bw.flush();
        bw.close();
    }
}