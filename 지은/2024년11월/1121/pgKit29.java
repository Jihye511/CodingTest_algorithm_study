import java.util.*;

class Solution {
    static int[] parent;
    static boolean[] visit;
    static Node[] graph;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        graph = new Node[costs.length];
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        
        for(int i = 0; i<costs.length; i++) {
            graph[i] = new Node(costs[i][0], costs[i][1], costs[i][2]);
        }
        
        Arrays.sort(graph);
        
        for(Node node : graph) {
             if(!check(node.a, node.b)) {
                 answer += node.value;
                 union(node.a, node.b);
             }
        }
        
        return answer;
    }
    
    int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }
    
    boolean check(int a, int b) {
        return find(a) == find(b);
    }
    
    
}

class Node implements Comparable<Node>{
    int a,b,value;
    
    public Node(int a, int b, int v) {
        this.a = a;
        this.b = b;
        this.value = v;
    }
    
    public int compareTo(Node c) {
        return this.value - c.value;
    }
}