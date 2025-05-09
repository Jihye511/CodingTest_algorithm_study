import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int[] checkPerson;
    static ArrayList<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //사람수
        int m = Integer.parseInt(st.nextToken()); //파티수

        parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int real = Integer.parseInt(st.nextToken());
        checkPerson = new int[real];
        if(real != 0) {
            for(int i=0;i<real;i++) {
                checkPerson[i] = Integer.parseInt(st.nextToken());
            }
        }

        party = new ArrayList[m];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            party[i] = new ArrayList<>();
            for(int j=0;j<count;j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<party.length; i++) {
            int first = party[i].get(0);
            for(int j=1;j<party[i].size();j++) {
                union(first, party[i].get(j));
            }
        }

        int result = 0;
        for(int i=0; i<party.length; i++) {
            boolean res = true;
            for(int j=0;j<checkPerson.length;j++) {
                if(!check(checkPerson[j],party[i].get(0))) res = false;
            }
            if(res) result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    static int find(int x) {
        if(parent[x]==x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }

    static boolean check(int a, int b) {
        return find(a) != find(b);
    }


}