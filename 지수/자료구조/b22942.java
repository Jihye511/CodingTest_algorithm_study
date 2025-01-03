package 자료구조;

import java.io.*;
import java.util.*;
public class b22942 {
    private static int N;
    private static boolean flag = false;

    private static class Circle implements Comparable<Circle> {
        int num;    // 원의 번호
        int coordinate;    // 원의 중심 좌표

        public Circle(int num, int coordinate) {
            this.num = num;
            this.coordinate = coordinate;
        }

        @Override
         public int compareTo(Circle o) {
            if (this.coordinate == o.coordinate) {
                flag = true;
            }
            return this.coordinate - o.coordinate;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Circle> pq = new PriorityQueue<>();
        Stack<Integer> stack = new Stack<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            pq.add(new Circle(i, x - r));
            pq.add(new Circle(i, x + r));
        }

        if (flag) {
            System.out.println("NO");
            return;
        }

        while (!pq.isEmpty()) {
            if (stack.isEmpty()) {
                stack.push(pq.poll().num);
            } else {
                int circleNum = pq.poll().num;
                if (stack.peek() == circleNum) {
                    stack.pop();
                } else {
                    stack.push(circleNum);
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }

}
