package greedy;

import java.util.Scanner;

//동전갯수의 최솟값
//백준 11047
public class Greedy1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //동전갯수
		int k = sc.nextInt(); //목표금액
		int[] a = new int[n];
		for (int i =0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		int[] count = new int[n];
		int totalCount =0;
		for (int i =0;i<n;i++) {
			count[i] = 0;
			
		}
		for (int i=n-1; i>=0; i--) {
			if(a[i]<=k) {
				count[i] = k/a[i];
				totalCount += k/a[i];
				k = k % a[i];
			}
		}
		for (int i=n-1; i>=0; i--) {
		System.out.println(a[i]+"원 동전"+count[i]+"개 ");	
		}
		System.out.println("총동전 "+totalCount+"개 사용햇습니다.");
	} // totalcount를 for문안에 넣지말고 그냥 count배열의 총합을 구하는게 낫지 않았을까...
}
