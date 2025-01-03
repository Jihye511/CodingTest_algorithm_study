package 자료구조;

import java.util.*;
import java.io.*;
public class b1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> operation = new Stack<>();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
            else if (c == '(') {
                operation.add(c);
            }
            else if (c == ')') {
                while (!operation.isEmpty()) {
                    if (operation.peek() == '(') {
                        operation.pop();
                        break;
                    }
                    sb.append(operation.pop());
                }
            }
            else {
                while (!operation.isEmpty() && priority(operation.peek()) >= priority(c)) {
                    sb.append(operation.pop());
                }
                operation.add(c);
            }
        }
        while (!operation.isEmpty()) {
            sb.append(operation.pop());
        }
        System.out.println(sb);
    }

    private static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }
}
