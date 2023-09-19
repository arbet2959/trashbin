package search;

public class BinarySearch2 {
	static int binarySearch(int[] a, int n, int key) {
		int ps=0; // 시작
		int pe=n-1; // 끝
		int pc = (ps+pe)/2;
		while(ps<=pe) {
			if(a[pc]==key) {
				while(a[pc]==key) {
					pc--;
				}
				return pc+1; // key값과 같은 수 중에 제일 앞에것 출력
			}
			if(a[pc]>key) pe=pc-1;
			if(a[pc]<key) ps=pc+1;
			pc = (ps+pe)/2;
		}
		
		
		return -pc-1; // 찾기실패시 출력

	}
}
