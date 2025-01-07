import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int M = Integer.parseInt(br.readLine());
            sb.append(M/2+1).append("\n");
            List<Integer> nList = new ArrayList<>();
            int cnt = 0;

            for(int i=0; i<M; i++) {
                if(i % 10 == 0) st = new StringTokenizer(br.readLine());
                nList.add(Integer.parseInt(st.nextToken()));
                Collections.sort(nList);
                if(i%2 == 0) {
                    if (cnt == 9 || i == M - 1) {
                        sb.append(nList.get(i / 2)).append("\n");
                        cnt = 0;
                    } else {
                        sb.append(nList.get(i / 2)).append(" ");
                    }
                    cnt++;
                }
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}