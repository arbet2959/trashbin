package stackque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class PriorityQue1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			int abs1=Math.abs(o1);
			int abs2=Math.abs(o2);
			if(abs1==abs2)
				return o1-o2;//절대값이 같으면 그냥 오름차순
			else
				return abs1-abs2; //절대값오름차순
		});
		int request[] = new int[n];
		for(int i=0; i<n;i++) {
			
			request[i]= Integer.parseInt(br.readLine());
		}
		for(int i=0; i<n;i++) {
			if (request[i] !=0) {
				q.add(request[i]);// 0이아닌 숫자는 우선순위큐에 넣음
			}else {//0일때
				if(q.isEmpty()) System.out.println(0); //비어잇으면 0출력
				else System.out.println(q.poll()); //값이있을땐 제일작은값꺼내서출력(이미정렬돼있음)
			}
				 
		}
		
	}
}
