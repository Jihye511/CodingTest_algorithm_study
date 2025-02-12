import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16987 {

    static int N, eggs[][], crackedCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        simulation(0, 0);
        System.out.println(crackedCnt);
    }

    public static void simulation(int now, int cnt) {
        if (cnt == N - 1 || now == N) {
            crackedCnt = Math.max(crackedCnt, cnt);
            return;
        }
        
        if (eggs[now][0] <= 0) {   
            simulation(now + 1, cnt);
        } else { 
            for (int i = 0; i < N; i++) {
                if (i == now) {
                    continue;
                }
                if (eggs[i][0] > 0) {
                    eggs[i][0] -= eggs[now][1];
                    eggs[now][0] -= eggs[i][1];
                    simulation(now + 1, cnt + (eggs[i][0] <= 0 ? 1 : 0) + (eggs[now][0] <= 0 ? 1 : 0));
                    eggs[now][0] += eggs[i][1];
                    eggs[i][0] += eggs[now][1];
                }
            }
        }
    }
}
