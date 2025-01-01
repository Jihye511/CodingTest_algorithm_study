package 자료구조_0102;

import java.io.*;
import java.util.*;

class 백준_자료구조_2493{
    static  int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<int[]> stack = new Stack<>();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i  =1 ; i<=n; i++){
            int tower = Integer.parseInt(st.nextToken());
            while(!stack.empty()){
                if(stack.peek()[0] > tower){
                    sb.append(stack.peek()[1] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.empty()){
                sb.append("0").append(" ");
            }
            stack.push(new int[] {tower,i});
        }
        System.out.println(sb.toString());
    }

}