import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        //s가 숫자로만 이루어져 잇으면 숫자로 바꿔서 출력
        if(checkNum(s)){
            return Integer.parseInt(s);
        }
        String temp ="";
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                temp += ch;
            }
            else{
                sb.append(ch);
                temp = "";
                continue;
            }
            if(temp.equals("zero")){
                sb.append(0);
                temp = "";
            }
            else if(temp.equals("one")){
                sb.append(1);
                temp = "";
            }else if(temp.equals("two")){
                sb.append(2);
                temp="";
            }else if(temp.equals("three")){
                sb.append(3);
                temp="";
            }else if(temp.equals("four")){
                sb.append(4);
                temp="";
            }else if(temp.equals("five")){
                sb.append(5);
                temp="";
            }else if(temp.equals("six")){
                sb.append(6);
                temp="";
            }else if(temp.equals("seven")){
                sb.append(7);
                temp="";
            }else if(temp.equals("eight")){
                sb.append(8);
                temp="";
            }else if(temp.equals("nine")){
                sb.append(9);
                temp="";
            }
            
        }
        answer = Integer.parseInt(sb.toString());
        // HashMap<String, Integer> map = new HashMap<>();
        // for(int i =0; i<10; i++){
        //     map.put()
        // }
        
        return answer;
    }
    public static boolean checkNum(String s){
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                return false;
            }
        }
        return  true;
    }
}
