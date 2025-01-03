package 자료구조_0103;
import java.io.*;
import java.util.*;

class Circle {
    long left;
    long right;

    Circle(int x, int r) {
        this.left = (long) x - r;
        this.right = (long) x + r;
    }
}

class 백준_22942 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Circle[] circles = new Circle[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            circles[i] = new Circle(x, r);
        }

        Arrays.sort(circles, Comparator.comparingLong(c -> c.left));

        Stack<Circle> stack = new Stack<>();

        for (Circle c : circles) {
            while (!stack.isEmpty() && stack.peek().right < c.left) {
                stack.pop();
            }
            if (!stack.isEmpty() && c.left <= stack.peek().right) {
                System.out.println("NO");
                return;
            }
            stack.push(c);
        }

        System.out.println("YES");
    }
}
