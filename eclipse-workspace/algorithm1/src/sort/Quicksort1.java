package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//퀵정렬로 전체정렬하는법
//pivot을 기준 start값과 end값을 이동하면서 만날때까지좌우정렬
//다시 왼쪽과 오른쪽을 pivot을 설정하고 각각 좌우정렬
//반복
//백준11004
public class Quicksort1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());//n개의 수 중에 오름차순 k번째 값을 구해야함
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		} // n개의 수 배열
		quickSort(a,0,n-1,k-1); 
		System.out.println(a[k-1]);//k번쨰 수 출력
	}
// a배열을 start부터~end범위에서 k을 찾을떄까지 정렬하는 메소드
	public static void quickSort(int[] a, int start, int end, int k) {
		
		int pivot = partition(a,start,end);
		if (pivot==k)
			return;
		else if (k<pivot)
			quickSort(a,start,pivot-1,k); // k가 pivot보다 작으면 왼쪽그룹만 정렬
		else quickSort(a,pivot+1,end,k); //k가 pivot보다 크면 오른족그룸만 정렬
	}
	// 
	public static int partition(int[] a, int start, int end) {
		if(start+1==end) {
			if(a[start]>a[end]) swap(a,start,end);
			return end;
		}
		int m = (start+end)/2;
		swap(a,start,m);          
		int pivot = a[start]; //가운데에서 고르고 맨앞으로 옮긴후 피벗지정
		int i = start+1, j = end;
		while(i<=j) {
			while(j>=start+1 && pivot <a[i]) { j--; }
			while(i<=end && pivot > a[i]) { i++; }
			if (i <=j) { 
				swap(a,i++,j--); //i,j포인터를 값비교해서 이동시키면서 정렬
			}
		}
		a[start]=a[j]; 
		a[j]=pivot; //처음으로 빼놨던 pivot을 정렬된 두배열 사이에넣음
		return j; //pivot값의 위치 반환
	}
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;	
	}// 자리바꾸는 메소드 swap
	
	
} //망햇당 나중에다시보자....
