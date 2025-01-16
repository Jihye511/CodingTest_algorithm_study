import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String str = br.readLine();
            if(str == null || str.equals("")) break;
            int val = Integer.parseInt(str);
            root.insert(val);
        }

        postOrder(root);
    }

    static void postOrder(Node curr){
        if(curr == null) return;
        postOrder(curr.left);
        postOrder(curr.right);
        System.out.println(curr.val);
    }

    static class Node{
        int val;
        Node left, right;

        Node(int val){
            this.val = val;
        }

        void insert(int n){
            if(n < this.val){
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            }
            else{
                if(this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }
}