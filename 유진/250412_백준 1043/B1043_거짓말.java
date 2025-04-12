package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B1043_거짓말 {

    static int N, M;
    static int[] parent;
    static HashSet<Integer> truthGroup; // 진실을 아는 사람들이 속한 그룹
    static ArrayList<ArrayList<Integer>> parties;
    
    // Find 연산: 루트 노드를 찾는 함수
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축
    }
    
    // Union 연산: 두 집합을 합치는 함수
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            parent[y] = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 파티의 수

        // 부모 배열 초기화
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        truthGroup = new HashSet<>();
        
        // 진실을 아는 사람들 입력
        st = new StringTokenizer(br.readLine());
        int truthKnowers = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < truthKnowers; i++) {
            int person = Integer.parseInt(st.nextToken());
            truthGroup.add(person);
        }
        
        // 각 파티 정보 저장
        parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            
            ArrayList<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
            
            // 파티의 모든 사람을 같은 집합으로 묶기
            for (int j = 1; j < partySize; j++) {
                union(party.get(0), party.get(j));
            }
        }
        
        // 진실을 아는 사람들의 루트를 모두 찾아 truthGroup에 추가
        HashSet<Integer> truthRoots = new HashSet<>();
        for (int person : truthGroup) {
            truthRoots.add(find(person));
        }
        
        // 과장된 이야기를 할 수 있는 파티 계산
        int answer = 0;
        for (ArrayList<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}