package sort;

import java.util.Scanner;
//선택정렬
//백준 1427
// 최솟값or최댓값을 찾고
// n번째있는 데이터와 swap(n=1,2,3,..max)해서 정렬
public class Selectsort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] a = new int[str.length()];
		for (int i=0; i<str.length();i++) {
			a[i] = Integer.parseInt(str.substring(i, i+1));
		}
		for (int i=0; i<str.length(); i++) {
			int max =i;
			for (int j=i+1; j<str.length();j++) {
				if (a[j]>a[max])
				max= j;
			} //최댓값구하기
			if(a[i]<a[max]) {
				int temp = a[i];
				a[i] = a[max];
				a[max] = temp;
			} //swap
		}
		for (int i =0; i< str.length(); i++) {
			System.out.print(a[i]);
		}
	sc.close();
	}
}
