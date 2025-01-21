import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        TimePair[] arr = new TimePair[n];

        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new TimePair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        int res = 1;
        int i=1;
        int cur = arr[0].end;
        while(i<arr.length) {
            if(cur <= arr[i].start) {
                res++;
                cur = arr[i].end;
            }
            i++;
        }

        bw.write(String.valueOf(res));
        bw.flush();
        br.close();

    }

}

class TimePair implements Comparable<TimePair> {
    int start, end;

    TimePair(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(TimePair timePair) {
        if(this.end == timePair.end) {
            return this.start - timePair.start;
        }
        return this.end - timePair.end;
    }
}

