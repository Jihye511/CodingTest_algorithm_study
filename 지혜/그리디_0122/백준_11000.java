package 그리디_0122;

import java.io.*;
import java.util.*;
class Pair{
    int start;
    int end;
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class 백준_11000 {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static  void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Pair[] meetings =new Pair[N];

        for(int i =0; i<N ;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int start =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Pair(start,end);

        }
        Arrays.sort(meetings,(o1, o2) -> {
            if(o1.start == o2.start){
                return o1.end - o2.end;
            }
            return o1.start-o2.start;
        });
        pq.offer(meetings[0].end);
        for(int i =1; i<N; i++){
            if(pq.peek() <=meetings[i].start){
                pq.poll();
            }
            pq.offer(meetings[i].end);
        }
        System.out.println(pq.size());
    }
}
