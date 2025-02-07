import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Loc{
        int idx;
        int time;

        public Loc(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]); // 수빈이의 위치
        int k = Integer.parseInt(inputs[1]); // 동생의 위치

        int[]  visited = new int[100001];

        Queue<Loc> q = new LinkedList<>(); // location(위치) 저장
        q.add(new Loc(n, 1)); // 시작 time을 1로 해놓고, 결과 출력시 1 빼기. visited의 값이 0인 것(방문 안한 곳)과 구별해주기 위해서.
        visited[n] = 1; 

        while (!q.isEmpty()) {
            Loc now = q.poll();
            
            // 이렇게 쓰면 틀림
//            if(now.idx==k) {
//                visited[now.idx] = now.time;
//                System.out.println(now.time-1);
//                break;
//            }

            if(now.idx+1>=0 && now.idx+1<=100000){ // 앞으로 한칸
                if(visited[now.idx+1] == 0 || visited[now.idx+1] > now.time+1){
                    visited[now.idx+1] = now.time+1;
                    q.add(new Loc(now.idx + 1, now.time + 1));
                }
            }

            if(now.idx-1>=0 && now.idx-1<=100000){ // 뒤로 한칸
                if(visited[now.idx-1] == 0 || visited[now.idx-1] > now.time+1) {
                    visited[now.idx - 1] = now.time + 1;
                    q.add(new Loc(now.idx - 1, now.time + 1));
                }
            }

            if(now.idx*2>=0 && now.idx*2<=100000){ // 순간이동
                if(visited[now.idx*2] == 0 || visited[now.idx*2] > now.time) {
                    visited[now.idx*2] = now.time;
                    q.add(new Loc(now.idx*2, now.time));
                }
            }

        }

        System.out.println(visited[k]-1);



    }
}
