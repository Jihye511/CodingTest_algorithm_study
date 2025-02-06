import java.io.*;
import java.util.*;


public class Main {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] union;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] lands = new int[N][N];
        union = new int[N][N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                lands[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxUnionNum = bfs(lands, L, R);

        while(maxUnionNum > 0) {

            for (int i = 0; i < lands.length; i++)  {
                for (int j = 0; j < lands[0].length; j++) {

                    if (union[i][j] > 0) {
                        int tmp = map.getOrDefault(union[i][j], 0);
                        if (tmp > 0)  lands[i][j] = tmp;
                    }
                }
            }

            answer++;
            union = new int[N][N];
            maxUnionNum = bfs(lands, L, R);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int bfs(int[][] land, int L, int R) {
        Deque<int[]> q = new ArrayDeque<>();
        int unionNum = 1;

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (union[i][j] == 0) {
                    q.add(new int[] {i,j});
                    union[i][j] = unionNum++;
                    int count = 0;
                    int popular = 0;

                    while(!q.isEmpty()) {
                        int[] landPoint = q.poll();
                        popular += land[landPoint[0]][landPoint[1]];

                        for (int k = 0; k < 4; k++) {
                            int dy = landPoint[0] + Main.dy[k];
                            int dx = landPoint[1] + Main.dx[k];

                            if (dx >= 0 && dx < land[0].length && dy >= 0 && dy < land.length) {
                                if (union[dy][dx] == 0) {
                                    int gap = land[landPoint[0]][landPoint[1]] - land[dy][dx];
                                    if (gap < 0) gap *= -1;

                                    if (gap < L || gap > R) continue;
                                    union[dy][dx] = union[i][j];
                                    q.add(new int[] {dy, dx});

                                    count++;
                                }
                            }
                        }
                    }

                    if (count == 0){
                        unionNum--;
                        union[i][j] = 0;
                    }else {
                        map.put(union[i][j], (popular / (count + 1)));
                    }
                }
            }
        }

        return unionNum - 1;
    }

}