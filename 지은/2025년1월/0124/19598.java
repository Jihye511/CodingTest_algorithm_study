import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Time> pq = new PriorityQueue<>();
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Time(Long.parseLong(st.nextToken()), true));
            pq.add(new Time(Long.parseLong(st.nextToken()), false));
        }

        int count = 0;
        int result = 0;
        while(!pq.isEmpty()) {
            Time t = pq.poll();
            if(t.isStart) {
                count++;
                result = Math.max(result, count);
            }
            else count--;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}

class Time implements Comparable<Time> {
    long time;
    boolean isStart;

    public Time(long s, boolean b) {
        this.time = s;
        this.isStart = b;
    }

    public int compareTo(Time o) {
        return Long.compare(this.time, o.time);
    }
}