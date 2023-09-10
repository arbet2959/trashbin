package numbertheory;

import java.util.Scanner;

//에라토스테네스의 체
//백준 1929
public class EratosthenesSieve {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for(int i= 2; i<=n;i++) {//i=m으로 햇을때2의 배수가 안지워지는문제발생 2부터 만들어줘야함
			a[i]=i;
		}
		for(int i=2;i<=Math.sqrt(n);i++) {
			if (a[i]==0) {
				continue;
			}
			for(int j=i+i;j<=n;j=j+i) {
				a[j]=0;
			}
		} //체로 거름 i은 두고 2i>3i>4i......
		for(int i=m; i<=n; i++) {
			if (a[i] !=0) {
				System.out.println(a[i]); // 0이아닌 남은값=소수 출력
			}
		}
	sc.close();
	}
}
