package 그래프탐색_0203;
import java.io.*;
import java.util.*;
public class BOJ_16918_봄버맨 {
    static int R,C,N;
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int time=0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        /*
        1초 폭탄설치
        2초 가만히
        3초 폭탄 설치 안된 칸에 모두 폭탄설치
        4초 3초전에 설치된 폭탄 폭발(4면 인접한 칸 같이 폭발)

         */

        //1.처음 폭탄설치
        for(int i =0; i<R; i++){
            String str= br.readLine();
            for(int j =0; j<C; j++){
                map[i][j] = str.charAt(j);
            }
        }
        //2초
        time +=1;


        //3,4반복
        while(time>=1){
            if(time ==N)break;
            insertQue();
            putBomb();
            time+=1;
            if(time ==N)break;
            bomb();
            time+=1;
            if(time ==N)break;
            //탐색 - q에 넣기



        }
        for(char[] r : map){
            for(char v : r){
                sb.append(v);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void insertQue(){
        for(int i=0;i<R; i++){
            for(int j =0; j<C; j++){
                if(map[i][j] =='O'){
                    q.offer(new int[]{i,j});
                }
            }
        }
    }
    public static void putBomb(){
        for(int i=0;i<R; i++){
            for(int j =0; j<C; j++){
                if(map[i][j] =='.'){
                    map[i][j] ='O';
                }
            }
        }
    }
    public static void bomb(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            map[cur[0]][cur[1]] = '.';
            for(int i =0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 ||nx>=R || ny<0 || ny>=C) continue;
                map[nx][ny] ='.';

            }
        }
    }
}
