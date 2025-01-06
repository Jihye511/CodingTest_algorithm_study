package 자료구조_0106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_21939 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //가장 어려운 문제 순으로 정렬
        PriorityQueue<Problem> largestPQ = new PriorityQueue<>(Collections.reverseOrder());
        //가장 쉬운 문제 순으로 정렬
        PriorityQueue<Problem> smallestPQ = new PriorityQueue<>();

        //문제 번호당 난이도를 저장한 배열(최대 문제 번호 값 100,000)
        int[] levels = new int[100_001];

        //기본 추천 문제 리스트 초기화
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            levels[num] = level;

            Problem problem = new Problem(num,level);

            largestPQ.add(problem);
            smallestPQ.add(problem);
        }

        Set<String> solveSet = new HashSet<>();

        int M = Integer.parseInt(br.readLine());

        //추가 문제 더함
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            //문제를 추가하는 경우 해당 번호의 난이도를 갱신하고 각 최대/최소 문제 큐에 문제 추가
            if(command.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());

                levels[num] = level;
                Problem problem = new Problem(num,level);

                largestPQ.add(problem);
                smallestPQ.add(problem);
            }
            //문제를 추천하는 경우 번호-난이도의 키를 이용해 이미 풀어낸 문제를 제거
            else if(command.equals("recommend")){
                int val = Integer.parseInt(st.nextToken());

                if(val == 1){
                    //번호-난이도로 키 생성
                    String key = largestPQ.peek().num +"-"+largestPQ.peek().level;

                    //이미 푼 문제를 제거
                    while(solveSet.contains(key)){
                        largestPQ.poll();
                        key = largestPQ.peek().num +"-"+largestPQ.peek().level;
                    }
                    System.out.println(largestPQ.peek().num);
                }else{
                    //번호-난이도로 키 생성
                    String key = smallestPQ.peek().num +"-"+smallestPQ.peek().level;

                    //이미 푼 문제를 제거
                    while(solveSet.contains(key)){
                        smallestPQ.poll();
                        key = smallestPQ.peek().num +"-"+smallestPQ.peek().level;
                    }
                    System.out.println(smallestPQ.peek().num);
                }
            }else{
                int num = Integer.parseInt(st.nextToken());

                //문제-난이도 키를 등록
                solveSet.add(num+"-"+levels[num]);
            }
        }
    }
}

class Problem implements Comparable<Problem>{
    int num;
    int level;

    public Problem(int num, int level){
        this.num = num;
        this.level = level;
    }

    @Override
    public int compareTo(Problem o) {
        if(this.level == o.level){
            return this.num - o.num;
        }
        return this.level - o.level;
    }
}