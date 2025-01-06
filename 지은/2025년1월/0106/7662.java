import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> minPq = new PriorityQueue<>(); //오름차순
            PriorityQueue<Long> maxPq = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1)); //내림차순
            HashMap<Long, Integer> cnt = new HashMap<>();
            int size = 0;	//큐에 저장된 개수
            for(int k = 0; k<K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                long value = Long.parseLong(st.nextToken());

                if(operation.equals("I")) {
                    minPq.add(value);
                    maxPq.add(value);
                    cnt.put(value, cnt.getOrDefault(value, 0) + 1);
                    size++;
                } else {
                    if(size <= 0) continue;
                    size--;
                    if(value == -1) poll(minPq, cnt);
                    else poll(maxPq, cnt);
                }
            }
            if(size <= 0) sb.append("EMPTY").append("\n");
            else sb.append(getNum(maxPq, cnt)).append(" ").append(getNum(minPq, cnt)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    //'D' 명령어로 최소값이나 최대값 제거 진행하는 함수
    static void poll(PriorityQueue<Long> pq, HashMap<Long, Integer> cnt){
        //큐에 존재하는 최대값이나 최소값 탐색
        while(!pq.isEmpty()){
            long temp = pq.poll();
            if(cnt.get(temp) == 0)	//큐에 존재하지 않는 수일 때
                continue;
            cnt.put(temp, cnt.get(temp) - 1);	//최대값이나 최소값 제거!
            break;
        }
    }
    //최대값이나 최소값 구하는 함수
    static long getNum(PriorityQueue<Long> pq, HashMap<Long, Integer> cnt){
        //큐에 존재하는 값 탐색
        while(!pq.isEmpty()){
            long temp = pq.poll();
            if(cnt.get(temp) == 0)	//큐에 존재하지 않는 값일 때
                continue;
            return temp;	//최대값이나 최소값 반환
        }
        return -1;
    }

}