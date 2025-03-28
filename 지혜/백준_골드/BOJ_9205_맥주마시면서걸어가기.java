import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static class Point{
        int x,y,hp;

        public Point(int x,int y,int hp){
            this.x=x;
            this.y=y;
            this.hp=hp;

        }
    }
    static int n;
    static int[][] map;
    static Point point;
//    static int cx,cy;   //상근 좌표
    static int fx,fy; //festival좌표
    static ArrayList<int[]> store;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            map = new int[n][n];
             int cx = Integer.parseInt(st.nextToken());
             int cy = Integer.parseInt(st.nextToken());
            point = new Point(cx,cy,1000);
            store = new ArrayList<>();
            v = new boolean[n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                store.add(new int[]{x,y});
            }
            //스토어 집이랑 가까운곳부터 정렬
            Collections.sort(store, (a,b)->a[0]-b[0]);
            st = new StringTokenizer(br.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());
            System.out.println(move());
        }


    }
    public static int calculate(int cx, int cy, int ax, int ay){
        int dis = Math.abs(cx-ax)+Math.abs(ay-cy);
        return dis;
    }

    public static String move(){
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        while(!q.isEmpty()){
            Point p = q.poll();
            //현재거리에서 페스티벌 거리까지 확인
            if (calculate(p.x, p.y, fx, fy)<= p.hp) return "happy";
            for(int i =0; i<store.size(); i++){
                //현재거리에서 편의점 까지의 거리 계산해보기
                if(!v[i]&& calculate(p.x, p.y, store.get(i)[0], store.get(i)[1])<=p.hp){
                    v[i]=true;

                    q.offer(new Point(store.get(i)[0],store.get(i)[1],1000));

                }
            }
        }
        return "sad";
    }

}
