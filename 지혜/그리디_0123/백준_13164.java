package 그리디_0123;

import java.io.*;
import java.util.*;
public class 백준_13164 {
    static int N,K;
    static int[] child;
    static int[] subTall;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        child = new int[N];
        subTall = new int[N-1];
        st= new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            child[i] = Integer.parseInt(st.nextToken());
        }

        //키 차이 저장
        for(int i =0; i<N-1; i++){
            subTall[i] = child[i+1]-child[i];
        }
        Arrays.sort(subTall);
        int cnt=0;
        for(int i =0; i<N-K; i++){
            cnt+= subTall[i];
        }
        System.out.println(cnt);
    }
}
