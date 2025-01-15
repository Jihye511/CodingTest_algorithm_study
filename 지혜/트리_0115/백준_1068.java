import java.io.*;
import java.util.*;

public class Main
{
	static int n ;
	static ArrayList<Integer>[] list;
	static int root;
	static ArrayList<Integer> leaf = new ArrayList<>();
	static int rm; //지울 노드
	static int leafCount=0;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list= new ArrayList[n];
		for(int i =0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n; i++) {
			
			int a = Integer.parseInt(st.nextToken());
			if(a ==-1) {
				//루트
				root=i;
			}
			else {
				list[a].add(i);
			}
		}
		
		rm = Integer.parseInt(br.readLine());
		//리프에 있는지 탐색
		if(root==rm) {
			System.out.println(0);
			return;
		}
		//리프에 rm 없으면
		dfs(root);
		System.out.println(leafCount);
	}
	public static void dfs(int node) {
        // 삭제할 노드의 서브트리는 탐색하지 않음
        if (node == rm) return;

        //자식 노드 탐색
        int childCount =0;
        for(int child : list[node]) {
        	if(child != rm) {
        		dfs(child);
        		childCount++;
        	}
        }
        if(childCount==0) {
        	leafCount++;
        }
    }
}
