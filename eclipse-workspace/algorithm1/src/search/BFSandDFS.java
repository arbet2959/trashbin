package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS BFS 둘다쓰는거 해보기
//백준 1260
public class BFSandDFS {
	static boolean visited[];
	static ArrayList<Integer>[] a;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//노드
		int m = sc.nextInt();//엣지
		int start = sc.nextInt();//시작점
		a = new ArrayList[n+1];
		for (int i=1; i<n+1;i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i=0;i<m;i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			a[s].add(e);
			a[e].add(s); //방향없는엣지임
		}
		
		for(int i=1;i<n+1;i++) { //작은값부터 넣기위해 오름차순 정렬
			Collections.sort(a[i]);
		}
		visited = new boolean[n+1];
		dfs(start);
		System.out.println();
		visited = new boolean[n+1]; // 방문배열 다시 초기화하는거 잊지말것;; 메소드로안에넣을까 했는데 dfs는 재귀형식이라
		                            // 넣기곤란 bfs만 넣으면 뭔가 통일성이 떨어지는거같음
		bfs(start);
		sc.close();
	}// 메인종료

	

	private static void dfs(int node) {
		System.out.print(node+" ");
		visited[node] = true; //시작부분을 접근,출력>방문배열바꿔줌
		for (int i : a[node]) { // a[]배열 전체에 대해
			if(!visited[i]) { //방문노드가 false면 dfs실행
				dfs(i);
			}
		}	
	}
	
	private static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>(); //큐구현
		q.add(node); 
		visited[node] =true; //시작점을 넣고 방문배열 바꿔줌
		
		while(!q.isEmpty()) { //큐가 빌떄까지 반복
			int now = q.poll(); 
			System.out.print(now+" "); //시작점을 꺼내고 출력
			for (int i : a[now]) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	
}
