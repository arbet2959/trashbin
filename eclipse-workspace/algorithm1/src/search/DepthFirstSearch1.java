package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 11724
//깊이우선탐색 DFS  재귀 or stack사용
//arraylist로 인접리스트 표현
//arraylist접근하면서  방문배열을 true로 변경
public class DepthFirstSearch1 {
	static boolean visited[];
	static ArrayList<Integer>[] a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1]; // 0을 안쓰고 1~n까지만 쓰는게편해서
		a = new ArrayList[n+1];
		for(int i=1;i<n+1;i++) { //인접리스트 선언
			a[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) { // 인접리스트 초기화
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			a[s].add(e);
			a[e].add(s); // 양방향모두가능
		}
		int count =0;
		for (int i=1;i<n+1;i++) { //연결요소가 여러개일경우가 있음
			if(!visited[i]) { //방문하지 않는 노드가 있으면 그걸 시작점으로 dfs실행)
				count++;
				dfs(i);
			}
		}
		System.out.println(count); //연결요소의 갯수출력
	} //메인종료
	public static void dfs(int i) { // i가 들어왔을때 방문했는지 안했는지 확인후 안했으면 했다는 표시(true)를 해준 후 dfs
		if(visited[i]) {
			return;
		}else {
			visited[i] = true;
			for(int j : a[i]) {
				dfs(j);
			}
		}
		
		
	}
}
