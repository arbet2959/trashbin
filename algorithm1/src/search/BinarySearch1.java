package search;

import java.util.Arrays;
import java.util.Scanner;

//이진탐색 BinarySearch
//백준 1920
// 중앙값을 선택하고 타깃데이터와 비교해서
//중앙값이 크면 왼쪽 중앙값이 더 작으면 오른쪽배열선택 반복
public class BinarySearch1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int[] a = new int[n]; //n개의 수 주어짐
		for(int i=0; i<n;i++) {
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		int m = sc.nextInt(); //찾을값 m개 주어짐
		for(int i=0; i<m;i++) {
			boolean find = false;
			int target = sc.nextInt();
			int start = 0;
			int end = a.length-1;
			while (start <=end) {
				int mid = (start+end)/2;
				int midValue = a[mid];
				if (midValue>target) {
					end = mid-1;
				}else if(midValue<target) {
					start = mid+1;
				}else {
					find = true;
					break;
				}
			}
			if(find) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			
		}
		
		sc.close();
	}
}
