import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Node root = new Node('A');
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char val = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insert(root,val,left,right);
        }

        preorder(root);
        sb.append("\n");
        inorder(root);
        sb.append("\n");
        postorder(root);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void insert(Node root, char val, char left, char right){
        if(root.val == val) {
            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        } else {
            if (root.left != null) insert(root.left, val, left, right);
            if (root.right != null) insert(root.right, val, left, right);
        }
    }

    static void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            sb.append(node.val);
            inorder(node.right);
        }
    }

    static void preorder(Node node) {
        if(node != null) {
            sb.append(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }

    static void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            sb.append(node.val);
        }
    }

}

class Node{
    char val;
    Node left;
    Node right;
    public Node(char val) {
        this.val = val;
    }
}
