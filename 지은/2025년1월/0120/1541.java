import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        String temp = "";
        int tempResult = 0;
        int result = 0;
        boolean check = false;
        for(int i = 0; i<input.length(); i++) {
            if(input.charAt(i) == '+') {
                tempResult += Integer.parseInt(temp);
                temp = "";
            } else if(input.charAt(i) == '-') {
                tempResult += Integer.parseInt(temp);
                if(check) result -= tempResult;
                else result += tempResult;
                check = true;
                tempResult = 0;
                temp = "";
            } else {
                temp += input.charAt(i);
            }
        }
        tempResult += Integer.parseInt(temp);
        if(check) result -= tempResult;
        else result += tempResult;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}