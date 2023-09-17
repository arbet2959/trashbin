package stackque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 2164
public class que1 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Queue<Integer> q = new LinkedList<>();
	int n = sc.nextInt();
	for(int i=1;i<=n;i++) {
		q.add(i);
	} //n까지자연수의 큐를 만듦
	while(q.size()>1) {
		q.poll(); //큐에 처음 넣은걸 버림
		q.add(q.poll());//하나더 버리고 그걸 큐에 넣음
	}//1장남을떄까지반복
	System.out.println(q.poll());//남은한장출력
	sc.close();
	}//메인종료
}
