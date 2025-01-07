package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class b2696 {
    private static int M;
    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;
    private static Queue<Integer> answers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();
            maxHeap = new PriorityQueue<>();
            minHeap = new PriorityQueue<>(Collections.reverseOrder());
            answers = new LinkedList<>();
            // 수열의 크기 입력받기
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());

            // 원소 입력받기
            if (M <= 10) {
                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= M; i++) {
                    int num = Integer.parseInt(st.nextToken());
                    addNumber(num);

                    if (i % 2 != 0) {
                        answers.add(findMedian());
                    }
                }
            }
            else {
                int l = M / 10;
                int m = M % 10;

                while (l-- > 0) {
                    st = new StringTokenizer(br.readLine());
                    for (int i = 1; i <= 10; i++) {
                        int num = Integer.parseInt(st.nextToken());
                        addNumber(num);

                        if (i % 2 != 0) {
                            answers.add(findMedian());
                        }
                    }
                }

                st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= m; i++) {
                    int num = Integer.parseInt(st.nextToken());
                    addNumber(num);

                    if (i % 2 != 0) {
                        answers.add(findMedian());
                    }
                }

            }

            System.out.println(getMedianCnt());
            int cnt = 0;
            while (!answers.isEmpty()) {
                if (cnt == 10) {
                    System.out.println();
                }
                System.out.print(answers.poll() + " ");
                cnt++;
            }
            System.out.println();
        }


    }

    private static void addNumber(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private static int findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return 0;
    }

    private static int getMedianCnt() {
        if (M % 2 == 0) {
            return M / 2;
        }
        return M / 2 + 1;
    }
}
