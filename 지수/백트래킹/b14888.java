import java.io.*;
import java.util.*;
public class b14888 {
    static int N;
    static int[] A;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());


        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        rec(A[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void rec(int now, int idx){
        if(idx == N){
            max = Math.max(now,max);
            min = Math.min(now,min);
            return;
        }

        for(int i=0; i<4; i++){

            if(operators[i]>0){
                operators[i]--;

                switch(i){
                    case 0:
                        rec(now + A[idx], idx + 1);
                        break;
                    case 1:
                        rec(now - A[idx], idx + 1);
                        break;
                    case 2:
                        rec(now * A[idx], idx + 1);
                        break;
                    case 3:
                        rec(now / A[idx], idx+1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}

