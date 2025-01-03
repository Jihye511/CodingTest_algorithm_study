import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    static class Point implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o){
            if(this.y == o.y)
                flag = true;
            return this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Point(i, x - y));
            pq.offer(new Point(i, x + y));
        }

        if(flag) {
            bw.write("NO");
            bw.flush();
            bw.close();
            System.exit(0);
        }
        while (!pq.isEmpty()) {
            if (stack.isEmpty()) {
                stack.push(pq.poll().x);
            }
            else{
                int t = pq.poll().x;
                if(stack.peek() == t)
                    stack.pop();
                else
                    stack.push(t);
            }
        }

        if (stack.isEmpty())
            bw.write("YES");
        else
            bw.write("NO");
        bw.flush();
        bw.close();
    }
}