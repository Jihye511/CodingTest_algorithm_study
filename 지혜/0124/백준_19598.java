import java.util.*;
import java.io.*;

class Pair{
    int start;
    int end;
    public Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}
public class Main {
    static int N;
    static Pair[] meetings;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        meetings = new Pair[N];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i] = new Pair(s,e);
        }
        Arrays.sort(meetings, ((a,b) -> {
            if(a.start == b.start){
                return a.end - b.end;
            }
            return a.start - b.start;
        }));

        pq.offer(meetings[0].end);

        for(int i =1; i<N; i++){
            if(pq.peek() <= meetings[i].start){
                pq.poll();
            }
            pq.offer(meetings[i].end);
        }
        System.out.println(pq.size());
    }
}
