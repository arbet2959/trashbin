package sort;

import java.util.Scanner;
//버블정렬
//백준 2750
//루프범위에서 인접한 두값을 비교swap
//나온값은 최솟값or최댓값이 돼서 제일 마지막에 정렬됨
//이후 정렬된 범위를 제외하고 반복 
public class Bubblesort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					
				}
			}
		}
		for (int i=0; i<n; i++) {
			System.out.println(a[i]);
		}
		sc.close();
	}
}
