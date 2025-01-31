package 완전탐색;

import java.io.*;
import java.util.*;

public class b1548 {
    static int n;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //삼각 수열의 최대 길이를 구하는 프로그램을 작성하시오.

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n==1 || n==2){
            System.out.println(n);
            return;
        }

        Arrays.sort(arr);

        int len = 2;
        for(int i=0; i<n-2; i++){
            len = 2;
            for(int j=i+2; j<n; j++){
                if(arr[i]+arr[i+1] > arr[j]){
                    len++;
                }
                else{
                    break;
                }
            }
            answer = Math.max(answer, len);
        }

        System.out.println(answer);

    }
    
}

좋아요공감
공유하기게시글 관리
구독하기
