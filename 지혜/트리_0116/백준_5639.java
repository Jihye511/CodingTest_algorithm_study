package 트리_0116;

import java.io.*;

class Node {
    int num;
    Node left, right;

    Node(int num) {
        this.num = num;
    }

    // 이진 탐색 트리에 노드 추가
    void insert(int num) {
        if (num < this.num) { // 왼쪽에 삽입
            if (this.left == null) {
                this.left = new Node(num);
            } else {
                this.left.insert(num);
            }
        } else { // 오른쪽에 삽입
            if (this.right == null) {
                this.right = new Node(num);
            } else {
                this.right.insert(num);
            }
        }
    }
}

public class 백준_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 첫 입력을 루트로 설정
        Node root = new Node(Integer.parseInt(br.readLine()));

        // 입력받아 트리 구성
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            root.insert(Integer.parseInt(input));
        }

        // 후위 순회 출력
        postOrder(root);
    }

    // 후위 순회 메서드
    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);  // 왼쪽 서브트리
        postOrder(node.right); // 오른쪽 서브트리
        System.out.println(node.num); // 루트
    }
}
