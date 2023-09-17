package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS깊이우선탐색 큐사용
//백준 2187
public class BreadthFirstSearch {
	static int[] dx = {0, 1, 0 ,-1};
	static int[] dy = {1, 0, -1 ,0};
	static boolean[][] visited;
	static int[][] a;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		visited = new boolean[n][m];
		for (int i=0; i<n;i++) {
			st =new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j=0;j<m;j++) {
				a[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		bfs(0,0);
		System.out.println(a[n-1][m-1]); //목표값까지의 최단거리 출력
	}
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i,j});
		visited[i][j] = true;
		while(!q.isEmpty()) {
			int now[] = q.poll();
			for(int k=0;k<4;k++) { //상하좌우탐색
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (x>=0 && y>=0 && x<n && y<m) { //배열을 넘어가면 안댐
					if(a[x][y] !=0 && !visited[x][y]) { //0인곳이나 이미 visit한곳(true인곳)은 갈수 없음
						visited[x][y] = true;
						a[x][y] = a[now[0]][now[1]]+1; //이동했을때 +1 해줌 = 이동거리
						q.add(new int[] {x,y});
					}
				}
			}
		}
		
	}
}
