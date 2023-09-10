package sort;

import java.util.Scanner;

//삽입정렬
//백준 11399
//
public class InsertionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] s = new int[n];
		for(int i=0; i<n; i++) { // a배열에 각 사람이 걸리는 시간 입력
		a[i] = sc.nextInt(); 
		}
		for(int i=1; i<n; i++) { //삽입정렬, i는 대상 0~j는 범위
			int insert_point = i;
			int insert_value = a[i];
			for(int j=i-1; j>=0; j--) { // 삽입위치찾기
				
				if(a[j]<a[i]) {
					insert_point = j+1;
					break;
				}
				if(j==0) {
					insert_point = 0;
					break;
				}
				
			}
			for(int j=i; j>insert_point; j--) {//찾은위치에서 한칸씩 밀어서 삽입할 공간만들기
				a[j] = a[j-1];
			}
			a[insert_point]=insert_value; //삽입
		}
		
		s[0]=a[0];
		for(int i=1;i<n;i++) { //합배열 s[i]= i번쨰사람이 걸리는시간
			s[i]=s[i-1]+a[i];
		}
		
		int sum = 0;
		for(int i=0; i<n; i++) { // sum은 i번쨰사람까지 걸리는 총시간
			sum = sum+s[i];
		}
		System.out.println(sum);
		sc.close();
	}
}
