package 자료구조_0102;

import java.io.*;
import java.util.*;

class 백준_자료구조_2800{
    static  char[] ch;
    static List<int[]> list = new ArrayList<>();
    static Set<String> set = new TreeSet<>();
    static boolean[] check;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ch = new char[str.length()];
        for(int i =0; i<str.length(); i++){
            ch[i] = str.charAt(i);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<ch.length; i++){
            if(ch[i] == '('){
                stack.push(i);
            }else if(ch[i]==')'){
                list.add(new int[]{stack.pop(),i});
            }
        }
        check = new boolean[ch.length];
        combi(0);

        for(String s : set){
            System.out.println(s);
        }


    }
    public static void combi(int depth){
        if(depth == list.size()){
            boolean temp = false;
            StringBuilder sb = new StringBuilder();
            for(int i =0; i<ch.length; i++){
                if(!check[i]){
                    sb.append(ch[i]);
                }
                else{
                    temp = true;
                }
            }
            if(temp){
                set.add(sb.toString());
            }
            return;
        }

        //현재 괄호 제거 x
        combi(depth+1);
        //현재 괄호 제거 o
        int[] pair = list.get(depth);
        check[pair[0]] = true;
        check[pair[1]] = true;
        combi(depth+1);
        check[pair[0]] = false;
        check[pair[1]] = false;
    }
}