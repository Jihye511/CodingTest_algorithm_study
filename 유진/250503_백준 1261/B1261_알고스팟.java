package gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Arrays;
public class B1261_알고스팟 {



    static int N,M;
    static int map[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static String str;
    static int solution = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        M = Integer.parseInt(inputs[0]);
        N = Integer.parseInt(inputs[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for(int j=0;j<M;j++){
                   map[i][j] = str.charAt(j)-'0';
            }
        }

        dijs();
        System.out.println(solution);
    }

    private static void dijs() {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.brokenValue - o2.brokenValue);
        queue.add(new Node(0,0,0));
        boolean visited[][] =new boolean[N][M];
        visited[0][0] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x == N - 1 && node.y == M-1){
                solution = Math.min(node.brokenValue,solution);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nextBroken = node.brokenValue;

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                       if(!visited[nx][ny]){
                           if(map[nx][ny] == 1) {
                               queue.add(new Node(nx,ny,++nextBroken));
                           } else {
                               queue.add(new Node(nx,ny,nextBroken));
                           }
                       }
                        visited[nx][ny] = true;
                    }
            }
        }
    }

    static class Node{
        int x;
        int y;

        int brokenValue;
        public Node(int x,int y,int brokenValue){
            this.x = x;
            this.y = y;
            this.brokenValue = brokenValue;
        }
    }


}