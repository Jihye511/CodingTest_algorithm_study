import java.io.*;
import java.util.*;

public class Main {
    static int N,M,k;
    static int[] A;
    static ArrayList<Integer>[] list;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i =0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        A = new int[N+1];
        //가격순으로 정렬해야됨
        ArrayList<int[]> idxList = new ArrayList<>();


        st = new StringTokenizer(br.readLine());
        for(int i =1;i<=N; i++){
            A[i] =Integer.parseInt(st.nextToken());
            idxList.add(new int[]{i,A[i]});

        }
        //가격순으로 정렬
        Collections.sort(idxList,(a,b)->a[1]-b[1]);

        v=new boolean[N+1];
        for(int i =0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            list[v].add(w);
            list[w].add(v);
        }

        int cnt=0;//만든 친구수
        int cost=0;
            for(int i=0; i<N; i++){
                int idx = idxList.get(i)[0];
                if(!v[idx]){
                    v[idx]=true;
                    if(A[idx] <= k){
                        k-=A[idx];
                        cost+=A[idx];
                        cnt += bfs(idx);
                    }
                }
            }
            if(cnt!=N){
                System.out.println("Oh no");
            }else{
                System.out.println(cost );
            }
    }
    public static int bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        v[n] = true;
        int fcnt=1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i =0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                if(!v[next]){
                    v[next] = true;
                    q.offer(next);
                    fcnt++;
                }
            }
        }
        return fcnt;
    }

}
