package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16562_친구비 {
	static int[] fee;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        fee = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            fee[i]= Integer.parseInt(st.nextToken());
        }

        parent = new int[N+1];

        for(int i=1;i<N+1;i++){
            parent[i]=i;
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union_parent(a,b);
        }

        int sum = 0;
	
        //본인이 부모노드인 경우만 sum에 더하기
        for(int i=1;i<=N;i++){
            if(parent[i]==i){
                sum+=fee[i];
            }
        }

        // 가능한지 판단
        if(sum<=K){
            System.out.println(sum);
        }else{
            System.out.println("Oh no");
        }

    }

    private static void union_parent(int a, int b) {
        a=find_parent(a);
        b=find_parent(b);
        
        // a와 b의 친구비를 계산해 더 싼 친구비의 요소로 부모노드를 가져감
        if(fee[a]<fee[b]){
            parent[b]=a;
        }else{
            parent[a]=b;
        }
        

    }

    private static int find_parent(int a){
        if(parent[a]!=a){
            parent[a] = find_parent(parent[a]);
        }
        return parent[a];
    }

}
