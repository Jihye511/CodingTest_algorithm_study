package 완전탐색_0131;
import java.io.*;
import java.util.*;
public class 백준_1548_부분삼각수열 {
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for(int i =0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1 || N== 2){
            System.out.println(N);
            return;
        }

        Arrays.sort(num);
        int len =2;
        for(int i =0; i<N-2; i++){
            len =2;
            for(int j=i+2; j<N; j++){
                if(num[i] +num[i+1] > num[j]){
                    len ++;
                }
                else{
                    break;
                }
            }
            ans = Math.max(ans, len);
        }
        System.out.println(ans);
    }
}
